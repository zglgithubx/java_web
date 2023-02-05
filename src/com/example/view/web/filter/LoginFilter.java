package com.example.view.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/pageQueryServlet",dispatcherTypes={DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request=(HttpServletRequest)req;
//        HttpServletResponse response=(HttpServletResponse)resq;
        //        chain.doFilter(req, resp);
        String uri=request.getRequestURI();
        //判断是否包含登录相关资源路径
        if(uri.contains("/LoginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/CheckCodeServlet")||uri.contains("/pageQueryServlet")){
            chain.doFilter(req, resp);
        }else{
            Object user=request.getAttribute("user");
            if(user!=null){
                chain.doFilter(req, resp);
            }else{
                request.getRequestDispatcher("/index.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
