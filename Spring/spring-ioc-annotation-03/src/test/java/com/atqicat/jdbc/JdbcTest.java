package com.atqicat.jdbc;

import atqicat.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    /*
    * JdbcTemplate 简化数据库的crud 不提供连接池
    * DruidDataSource 负责连接池的创建和数据库驱动的注册
    * */
    @Test
    public void testForJava(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.finAll();
        applicationContext.close();
        System.out.println(controller);
    }
}
