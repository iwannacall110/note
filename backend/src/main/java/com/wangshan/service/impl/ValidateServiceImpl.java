package com.wangshan.service.impl;

import com.wangshan.dao.UserDao;
import com.wangshan.models.User;
import com.wangshan.service.UserService;
import com.wangshan.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
@Service
public class ValidateServiceImpl implements ValidateService{
    @Override
    public Boolean validatePassword(String email, String password){
        return true;
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
