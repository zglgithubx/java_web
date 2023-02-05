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

@WebServlet("/echoServlet")
public class echoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        FirstCaseService firstCaseService=new FirstCaseServiceImpl();
        FirstCase firstCase=firstCaseService.findOne(id);
        request.setAttribute("firstcase",firstCase);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
