package com.wangshan.dao;

import com.wangshan.models.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface UserDao {
    int insertUser(User user);
    List<User> selectUser();
    User getUserByEmail(String email);
}
