package com.example.view.web.servlet;

import com.example.model.domain.FirstCase;
import com.example.model.domain.PageBean;
import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/pageQueryServlet")
public class pageQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage=request.getParameter("currentPage");//当前页码
        String rows=request.getParameter("rows");//每页显示条数
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }
//        获取条件查询参数
        Map<String,String[]> condition=request.getParameterMap();

        //调用service查询
        FirstCaseService firstCaseService=new FirstCaseServiceImpl();
        PageBean<FirstCase> pb=firstCaseService.pageQuery(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
