package com.wangshan.dao;

import com.wangshan.models.UserToken;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface UserTokenDao {
    int insertUserToken(UserToken userToken);
    UserToken selectUserTokenByToken(String token);
}
