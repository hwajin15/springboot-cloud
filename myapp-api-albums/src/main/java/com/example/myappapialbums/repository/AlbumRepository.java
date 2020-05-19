package com.example.myappapialbums.repository;

import com.example.myappapialbums.data.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
    AlbumEntity findByName(String name);
}
