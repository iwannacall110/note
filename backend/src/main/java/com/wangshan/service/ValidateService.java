package com.wangshan.service;

import com.wangshan.models.User;

/**
 * 验证服务, 所有敏感信息都不提供直接查询接口，只提供验证接口
 * Created by shan on 2015/12/3.
 */
public interface ValidateService {
    /**
     * 验证用户
     * @param password
     * @return
     */
    public Boolean validatePassword(String email, String password);

    public Boolean validateMobileRepeat(String mobile);

    public Boolean validateEmailRepeat(String email);
}
