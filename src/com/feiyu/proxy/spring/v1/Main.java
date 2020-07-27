package com.feiyu.proxy.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过配置文件配置增强
 * app_auto.xml
 * 
 * spring aop test
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank t = (Tank)context.getBean("tank");
        t.move();
    }
}
