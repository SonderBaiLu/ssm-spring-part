package com.itqicat.ioc_05;

public class javaBean {
    private String name;
    public String getName(){
        return name;
    }
    public String setName(String name){
        return this.name = name;
    }

    @Override
    public String toString() {
        return "javaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
