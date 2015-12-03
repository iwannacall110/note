package com.wangshan.test;

import com.wangshan.models.User;
import com.wangshan.service.UserService;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/11/15.
 */

public class UserTest {
    private UserService userService;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml",
                "classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @Test
    public void addUser(){
        System.out.println("test");
        User user = new User();
        user.setName("test");
        user.setState(2);
        System.out.println(userService.insertUser(user));
    }
}
