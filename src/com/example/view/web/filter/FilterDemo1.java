package com.example.view.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
//@WebServlet("/*")//访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        服务器开启后创建filter对象，然后调用init方法，只执行一次。用于加载资源
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        过滤方法，可执行多次
//        对request请求消息增强
        System.out.println("dofilter被执行了");
        filterChain.doFilter(servletRequest,servletResponse);//放行
//        对response响应消息增强
    }

    @Override
    public void destroy() {
//        服务器正常关闭后filter对象被销毁，如果服务器是正常关闭，则会执行destroy方法。只执行一次，用于释放资源
    }
}
