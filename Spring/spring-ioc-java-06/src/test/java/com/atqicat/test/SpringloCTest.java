package com.atqicat.test;

import com.atqicat.ioc_01.Config.JavaConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringloCTest {
    @Test
     public void test(){
         // 创建ioc容器
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfiguration.class);
     }
}
