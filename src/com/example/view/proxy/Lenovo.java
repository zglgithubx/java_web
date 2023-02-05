package com.example.view.proxy;

import javax.servlet.ServletOutputStream;

/*
* 真实类
* */
public class Lenovo implements Sale {

    @Override
    public String sale(double money) {
        System.out.println("买一台联想电脑花了"+money);
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
