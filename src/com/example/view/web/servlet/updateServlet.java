package com.example.view.web.servlet;

import com.example.model.domain.FirstCase;
import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map=request.getParameterMap();
        FirstCase firstCase=new FirstCase();
        try {
            BeanUtils.populate(firstCase,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        FirstCaseService firstCaseService=new FirstCaseServiceImpl();
        firstCaseService.update(firstCase);
//        response.sendRedirect(request.getContextPath()+"/userListServlet");
        response.sendRedirect(request.getContextPath()+"/pageQueryServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
