package com.example.view.web.servlet;

import com.example.model.domain.FirstCase;
import com.example.model.service.FirstCaseService;
import com.example.model.service.impl.FirstCaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FirstCaseService firstCaseService=new FirstCaseServiceImpl();
        List<FirstCase> firstCaseList=firstCaseService.findALl();
        request.setAttribute("firstcase",firstCaseList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
