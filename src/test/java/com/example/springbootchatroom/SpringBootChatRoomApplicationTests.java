package com.example.springbootchatroom;

import com.example.springbootchatroom.code.entity.po.User;
import com.example.springbootchatroom.code.exception.RegisterException;
import com.example.springbootchatroom.code.mapper.UserMapper;
import com.example.springbootchatroom.code.service.IPermissionService;
import com.example.springbootchatroom.code.service.IUserService;
import com.example.springbootchatroom.code.stencil.BaseStencil;
import com.example.springbootchatroom.code.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@MapperScan(basePackages="com.example.springbootchatroom.code.mapper")
class SpringBootChatRoomApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    IUserService userService;

    @Resource
    private BaseStencil baseStencil;

    @Resource
    private IPermissionService permissionService;

    @Autowired
    RedisTemplate<String,Object>  redisTemplate;

    @Test
    void contextLoads() {
        User user = userService.queryOneUserByUsername("zcl");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getImage());
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

    @Test
    void test(){
        System.out.println(redisTemplate.getDefaultSerializer());
        System.out.println(redisTemplate.getValueSerializer());
        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(redisTemplate.getHashKeySerializer());
        System.out.println(redisTemplate.getStringSerializer());
        System.out.println(redisTemplate.getHashValueSerializer());
    }

    @Test
    void load4(){
//        RedisUtil.save("second",new User("a","b","c",false),7L, TimeUnit.DAYS);
        User user = (User) RedisUtil.getValue("second");
        System.out.println(user);
    }
}
