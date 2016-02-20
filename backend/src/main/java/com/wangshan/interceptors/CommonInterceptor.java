package com.wangshan.interceptors;

import com.wangshan.models.UserToken;
import com.wangshan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by shan on 2016/2/19.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        log.info("path: " + request.getServletPath());
        log.info("token: " + request.getHeader("token"));
        UserToken userToken = userService.getUserTokenByToken(request.getHeader("token"));
        if("/backend/user/login".equals(request.getServletPath()) || userToken != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
