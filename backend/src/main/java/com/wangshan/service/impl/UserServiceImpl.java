package com.wangshan.service.impl;

import com.wangshan.dao.UserDao;
import com.wangshan.models.User;
import com.wangshan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    @Override
    public List<User> getUser(){
        return userDao.selectUser();
    }

    @Override
    public User getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }
}
