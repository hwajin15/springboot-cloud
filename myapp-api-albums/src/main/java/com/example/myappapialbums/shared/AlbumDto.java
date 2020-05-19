package com.example.myappapialbums.shared;

import lombok.Data;

@Data
public class AlbumDto {
    private String albumId;
    private String userId;
    private String name;
    private String description;

}
