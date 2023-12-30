package com.atqicat.test;

import com.atqicat.Config.SpringConfig;
import com.atqicat.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = SpringConfig.class)
public class SpringioCTest {
    @Autowired
    private StudentController studentController;
    @Test
    public void test(){
        studentController.findAll();
    }
}
