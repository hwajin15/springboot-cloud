package com.example.myappapialbums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MyappApiAlbumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyappApiAlbumsApplication.class, args);
    }

}
