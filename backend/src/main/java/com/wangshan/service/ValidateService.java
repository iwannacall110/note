package com.wangshan.service;

import com.wangshan.models.User;

/**
 * ��֤����, ����������Ϣ�����ṩֱ�Ӳ�ѯ�ӿڣ�ֻ�ṩ��֤�ӿ�
 * Created by shan on 2015/12/3.
 */
public interface ValidateService {
    /**
     * ��֤�û�
     * @param password
     * @return
     */
    Boolean validatePassword(String email, String password);

    Boolean validateMobileRepeat(String mobile);

    Boolean validateEmailRepeat(String email);
}
