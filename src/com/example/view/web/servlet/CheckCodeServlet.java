package com.example.view.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、创建一个对象，在内存中图片
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
//        2、美化图片
//        填充背景色
        Graphics graphics=image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
//        画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=4;i++){
            int index= random.nextInt(str.length());
            char ch =str.charAt(index);
            sb.append(ch);
            graphics.drawString(ch+"",width/5*i,height/2);
        }
        String code=sb.toString();
        request.getSession().setAttribute("checkCode",code);
//        画干扰线
        graphics.setColor(Color.GREEN);
//        随机生成坐标点

        for(int i=0;i<10;i++){
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
//        3、将图片输出到页面上
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
