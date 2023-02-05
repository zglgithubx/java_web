package com.example.view.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String username=request.getParameter("username");
          Map<String,Object> map=new HashMap<String,Object>();
          response.setContentType("text/html;charset=utf-8");
         if("tom".equals(username)){
             map.put("userExsit",true);
             map.put("msg","此用户名太受欢迎,请更换一个");
         }else{
             map.put("userExsit",false);
             map.put("msg","这个名字很符合你的气质");
        }
        String value = new ObjectMapper().writeValueAsString(map);
        response.getWriter().write(value);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
