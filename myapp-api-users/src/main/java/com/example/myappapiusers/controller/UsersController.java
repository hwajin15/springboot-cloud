package com.example.myappapiusers.controller;


import com.example.myappapiusers.data.UserEntity;
import com.example.myappapiusers.model.CreateUserRequestModel;
import com.example.myappapiusers.model.CreateUserResponseModel;
import com.example.myappapiusers.repository.UserRepository;
import com.example.myappapiusers.service.UserService;
import com.example.myappapiusers.shared.UserDto;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController  {
    @Autowired
    Environment env;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String status(){
        return String.format("working on port %s, secret=%s",
                env.getProperty("local.server.port"),
                env.getProperty("token.secret"));
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},

            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUsers(
            @Valid @RequestBody CreateUserRequestModel userDetails,
            HttpServletRequest req
    ){
        System.out.println(req.getRemoteAddr());
//        createUserRequestModel -> userDto (using ModelMapper)
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto =modelMapper.map(userDetails,UserDto.class);
        UserDto createDto = userService.createUser(userDto);



        //  return new ResponseEntity(HttpStatus.CREATED);
        CreateUserResponseModel returnValue =modelMapper.map(createDto,CreateUserResponseModel.class );
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

}
