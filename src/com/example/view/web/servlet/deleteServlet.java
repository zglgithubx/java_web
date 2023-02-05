package com.example.view.web.servlet;

import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id =request.getParameter("id");
        FirstCaseService firstCaseService=new FirstCaseServiceImpl();
        firstCaseService.delete(id);
        response.sendRedirect(request.getContextPath()+"/pageQueryServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        this.doPost(request, response);
    }
}
