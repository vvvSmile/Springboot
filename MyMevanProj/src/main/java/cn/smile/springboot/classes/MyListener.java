package cn.smile.springboot.classes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web 容器 MyListener 的监听器启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web 容器 MyListener 的监听器Destroyed");
    }
}
