package com.wangshan.service;

import com.wangshan.models.User;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface AdminService {
    public User getUser(Long id);
    public Integer addUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Long id);
}
