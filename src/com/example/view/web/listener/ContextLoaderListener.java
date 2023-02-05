package com.example.view.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ContextLoaderListener implements ServletContextListener {
    /**
     * 监听ServletContext对象创建的。ServletContext对象服务器启动后自动创建
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext=sce.getServletContext();
        //2.加载资源文件
        String contextConfigLocation=servletContext.getInitParameter("contextConfigLocation");
        //3.获取真实路径
        String realPath=servletContext.getRealPath(contextConfigLocation);
        //4.加载进内存
        try {
            FileInputStream fileInputStream=new FileInputStream(realPath);
            System.out.println(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
