package com.example.myappapialbums.service;

import com.example.myappapialbums.shared.AlbumDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AlbumService extends UserDetailsService {
    AlbumDto getAlbums(AlbumDto albumDto);

}
