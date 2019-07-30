package com.zhouxiaoxi.filter.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器
 * httpSessionListener来实如今线人数的统计
 * @author zhouzhaodong
 */
@WebListener
@Slf4j
public class HttpLister implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("又有人上线了，统计一下总人数吧！");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("又有人下线了，统计一下总人数吧！");
    }
}
