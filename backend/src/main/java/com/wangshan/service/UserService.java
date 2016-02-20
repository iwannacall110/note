package com.wangshan.service;

import com.wangshan.models.User;
import com.wangshan.models.UserToken;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface UserService {
    int insertUser(User user);
    List<User> getUser();
    User getUserByEmail(String email);
	int insertUserToken(UserToken userToken);
    UserToken getUserTokenByToken(String token);
}
