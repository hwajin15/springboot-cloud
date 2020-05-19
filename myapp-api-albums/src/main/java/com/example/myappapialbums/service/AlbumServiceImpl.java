package com.example.myappapialbums.service;


import com.example.myappapialbums.data.AlbumEntity;
import com.example.myappapialbums.repository.AlbumRepository;
import com.example.myappapialbums.shared.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService{

    AlbumRepository repository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }




    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AlbumEntity albumEntity = repository.findByName(name);
        if (albumEntity == null) {

        }
        return null;
    }

    @Override
    public AlbumDto getAlbums(AlbumDto albumDto) {
        return null;
    }
}
