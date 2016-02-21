package com.wangshan.service.impl;

import com.wangshan.dao.UserDao;
import com.wangshan.models.User;
import com.wangshan.service.ValidateService;
import com.wangshan.utils.gabriel.EncryptUtil;
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
        User user = userDao.getUserByEmail(email);
        if(user != null && new EncryptUtil().encrypt(password + "-" + user.getSalt(), "SHA-1").equals(user.getPassword())){
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
