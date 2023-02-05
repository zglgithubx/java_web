package com.example.view.web.servlet;

import com.example.model.domain.Province;
import com.example.model.service.ProvinceService;
import com.example.model.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProvinceServlet")
public class findProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*//        1.调用service查询
        ProvinceService provinceService=new ProvinceServiceImpl();
        List<Province> list=provinceService.findAllProvince();

//        2.序列化list为json
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(list);*/
        ProvinceService provinceService=new ProvinceServiceImpl();
        String json=provinceService.findJson();
        System.out.println("json:"+json);
//        3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
