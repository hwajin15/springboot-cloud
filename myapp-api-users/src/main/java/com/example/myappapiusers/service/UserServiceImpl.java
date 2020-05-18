package com.example.myappapiusers.service;

import com.example.myappapiusers.data.UserEntity;
import com.example.myappapiusers.model.AlbumResponseModel;
import com.example.myappapiusers.repository.UserRepository;
import com.example.myappapiusers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    UserRepository repository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository repository ,BCryptPasswordEncoder bCryptPasswordEncoder, RestTemplate restTemplate) {
        this.repository = repository;
        this.bCryptPasswordEncoder =bCryptPasswordEncoder;
        this.restTemplate = restTemplate;

    }


    @Override
    public UserDto createUser(UserDto userDetails) {

        //userDto -> userentity
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity =modelMapper.map(userDetails, UserEntity.class);
        repository.save(userEntity);


        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
        return returnValue;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByEmail(email);
        if (userEntity ==null){
            throw new UsernameNotFoundException(email);
        }
            return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),
                    true,true,true,true,new ArrayList<>());
    }

    @Override
    public UserDto getUserDetailByEmail(String email) {
        UserEntity userEntity =repository.findByEmail(email);
        if (userEntity == null){
            throw new UsernameNotFoundException(email);
        }
        //userentity -> userDto
        return new ModelMapper().map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity =repository.findByUserId(userId);
        if(userEntity == null){
            throw  new UsernameNotFoundException("User not found");

        }
        UserDto userDto =new ModelMapper().map(userEntity, UserDto.class);
        //call -> albums microservice
        ResponseEntity<List<AlbumResponseModel>> albumsListResponse =

        restTemplate.exchange
                (String.format("http://ALBUMS-WS/users/%s/albums",userId),
                HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<AlbumResponseModel>>() {
        });
        List<AlbumResponseModel> albumsList = albumsListResponse.getBody();
        userDto.setAlbums(albumsList);

        return userDto;
    }

}
