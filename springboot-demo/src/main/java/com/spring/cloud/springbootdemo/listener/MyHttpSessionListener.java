package com.spring.cloud.springbootdemo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * User: wcy
 * Date: 2017/8/17
 * Time: 11:22
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("ServletContex初始化");
    }

}