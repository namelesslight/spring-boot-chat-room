package com.example.springbootchatroom.code.entity.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDownloadDto {

    private MultipartFile imageFile;

    private String imageName;

    private String imagePath;

}
