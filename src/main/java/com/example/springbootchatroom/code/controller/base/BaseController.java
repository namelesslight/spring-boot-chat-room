package com.example.springbootchatroom.code.controller.base;

import com.example.springbootchatroom.code.entity.dto.LoginDto;
import com.example.springbootchatroom.code.entity.dto.RegisterDto;
import com.example.springbootchatroom.code.result.Result;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Resource
    BaseStencil baseStencil;

    @PutMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto){
        return baseStencil.register(registerDto.getUsername(),
                registerDto.getPassword(),
                registerDto.getImagePath(),"/register");
    }

    @PostMapping("/login")
    public Result register(@RequestBody LoginDto loginDto){
        return baseStencil.login(loginDto.getUsername(), loginDto.getPassword(), "/login");
    }

        @PostMapping("/downloadImage")
    public Result download(@RequestParam MultipartFile imageFile,
                           @RequestParam String imagePath,
                           @RequestParam String imageName){
        return baseStencil.imageDownload(imageFile, imagePath, imageName, "/downloadImage");
    }
}
