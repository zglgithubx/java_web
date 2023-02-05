package com.example.view.web.servlet;

import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedServlet")
public class deleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids=request.getParameterValues("uid");
        for(String id:ids){
            FirstCaseService firstCaseService=new FirstCaseServiceImpl();
            firstCaseService.delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/pageQueryServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
