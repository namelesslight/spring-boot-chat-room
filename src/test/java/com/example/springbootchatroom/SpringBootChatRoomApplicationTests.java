package com.example.springbootchatroom;

import com.example.springbootchatroom.code.exception.RegisterException;
import com.example.springbootchatroom.code.mapper.UserMapper;
import com.example.springbootchatroom.code.service.IPermissionService;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan(basePackages="com.example.springbootchatroom.code.mapper")
class SpringBootChatRoomApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BaseStencil baseStencil;

    @Resource
    private IPermissionService permissionService;

    @Test
    void contextLoads() {
        System.out.println(userMapper);
        baseStencil.register("username","123456","/image/path","url");
    }

    @Test
    void Load2(){
        System.out.println(baseStencil.login("username","123456","url"));
    }

    @Test
    void  load3(){
        System.out.println(permissionService.listPermissionByRole("user"));
    }

    @Test
    void testException() throws RegisterException {
        throw new RegisterException("aaa");
    }
}
