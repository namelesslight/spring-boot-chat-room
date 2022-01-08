package com.example.springbootchatroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.springbootchatroom.code.mapper")
public class SpringBootChatRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootChatRoomApplication.class, args);
    }

}
