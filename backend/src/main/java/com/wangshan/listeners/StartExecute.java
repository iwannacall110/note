package com.wangshan.listeners;

import com.wangshan.utils.TimerTask.Task;
import com.wangshan.utils.TimerTask.Task2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2016/4/4.
 */
public class StartExecute extends HttpServlet implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("======================================startInit");
        new Task2();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
