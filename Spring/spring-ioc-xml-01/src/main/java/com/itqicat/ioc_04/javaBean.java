package com.itqicat.ioc_04;

public class javaBean {

    // 必须是publuic 必须是void返回值 必须是无参数的 方法名随意
    // 初始化方法 -> 初始化业务逻辑即可
    public void init(){
        System.out.println("init...");
    }

    public void clear(){
        System.out.println("clear...");
    }

}
