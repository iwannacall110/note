package com.wangshan.controllers;

import com.wangshan.base.Trys;
import com.wangshan.models.User;
import com.wangshan.service.UserService;
import com.wangshan.service.ValidateService;
import com.wangshan.utils.gabriel.EncryptUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by shan on 2015/12/2.
 */

@Controller
@RequestMapping("/backend/admin")
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ValidateService validateService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody User user, HttpSession session, HttpServletResponse response){
        if(validateService.validatePassword(user.getEmail(), user.getPassword())){
            EncryptUtil encryptUtil = new EncryptUtil();
            String token = encryptUtil.encrypt(user.getEmail() + user.getPassword() + DateTime.now(),"SHA-1");
            session.setAttribute("token", token);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            return "";
        } else {
            return Trys.notFound;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody User user, HttpSession session, HttpServletResponse response){
        new Thread(){ public void run(){

        }}.start();
        userService.insertUser(user);
        return "success";
    }

    public String forgetPassword(){
        return "";
    }
}
