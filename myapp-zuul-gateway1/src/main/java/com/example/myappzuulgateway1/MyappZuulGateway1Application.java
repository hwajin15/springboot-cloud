package com.example.myappzuulgateway1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MyappZuulGateway1Application {

    public static void main(String[] args) {
        SpringApplication.run(MyappZuulGateway1Application.class, args);
    }

}
