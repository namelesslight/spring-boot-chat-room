package com.example.springbootchatroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages="com.example.springbootchatroom.code.mapper")
@ServletComponentScan(basePackages = "com.example.springbootchatroom.code.filter")
public class SpringBootChatRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootChatRoomApplication.class, args);
    }

}
