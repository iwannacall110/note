package com.wangshan.controllers;

import com.wangshan.models.User;
import com.wangshan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2015/11/15.
 */
@Controller
@RequestMapping("/backend/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser(){
        return userService.getUser();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Object getUser(@RequestBody User user){
        System.out.println("==========================user: " + user.getName());
        return userService.getUser();
    }
}
