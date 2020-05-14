package com.example.myappapiusers.security;


import com.example.myappapiusers.model.LoginRequestModel;
import com.example.myappapiusers.service.UserService;
import com.example.myappapiusers.shared.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private UserService userService;
    private Environment env;

    public AuthenticationFilter(UserService userService , Environment env, AuthenticationManager authenticationManager){
        this.userService =userService;
        this.env = env;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {
        try {
            LoginRequestModel creds = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequestModel.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );

        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
            String email = ((User)authResult.getPrincipal()).getUsername();
            UserDto userDetail = userService.getUserDetailByEmail(email);

        //generate token with userId(email)
        //token expire_date (configuration or application.yml
        String token = Jwts.builder()

                .compact();
    res.addHeader("token",token);
    res.addHeader("userId", userDetail.getUserId());
    }

}