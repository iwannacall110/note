package com.wangshan.service.impl;

import com.wangshan.dao.UserDao;
import com.wangshan.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/11/15.
 */
@Service
public class ValidateServiceImpl implements ValidateService{
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean validatePassword(String email, String password){
        if(password.equals(userDao.getUserByEmail(email))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean validateMobileRepeat(String mobile){
        return false;
    }

    @Override
    public Boolean validateEmailRepeat(String email){
        return false;
    }
}
