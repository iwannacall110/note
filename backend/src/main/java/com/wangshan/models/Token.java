package com.wangshan.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/15.
 */

public class Token {
    private User user;
    private String token;
    public Token(){}
    public Token(User user,String token){
        this.user = user;
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
