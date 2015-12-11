package com.wangshan.service;

import com.wangshan.models.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface UserService {
    int insertUser(User user);
    List<User> getUser();
}
