package com.itqicat.ioc_05;

import org.springframework.beans.factory.FactoryBean;


/*
* 步骤
* 1. 实现FactoryBean接口<返回值类型>
* */
public class javaBeanFactoryBean implements FactoryBean<javaBean> {

    private String name;

    @Override
    public javaBean getObject() throws Exception {
        //使用自己的方式是实例化对象
        javaBean javaBean = new javaBean();
        javaBean.setName(this.name);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return javaBean.class;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
