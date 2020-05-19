package com.example.myappapialbums.controller;

import com.example.myappapialbums.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    Environment env;

    @Autowired
    AlbumService albumService;

    @GetMapping("/status/check")
    public String status(){
        return String.format("working on port %s , secret=%s",
                env.getProperty("local.server.port"));
    }
}
