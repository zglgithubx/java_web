package com.example.view.web.servlet;

import com.example.model.dao.UserDao;
import com.example.model.dao.impl.FirstCaseDaoImpl;
import com.example.model.dao.impl.UserDaoImpl;
import com.example.model.domain.User;
import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode=request.getParameter("verifycode");
        HttpSession httpSession=request.getSession();
        String check=(String) httpSession.getAttribute("checkCode");
        httpSession.removeAttribute("checkCode");
        Map<String,String[]> map=request.getParameterMap();

        if(check!=null&&check.equalsIgnoreCase(checkCode)){
            User user=new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            FirstCaseService firstCaseService=new FirstCaseServiceImpl();
            User user1=firstCaseService.login(user);
            if(user1!=null){
                httpSession.setAttribute("user",user1.getUsername());
                response.sendRedirect(request.getContextPath()+"/pageQueryServlet");
            }else{
                request.setAttribute("error","账号或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("error","验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
