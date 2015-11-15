package com.wangshan.service;

import com.wangshan.models.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface UserService {
    public int insertUser(User user);
    public List<User> getUser();
}
