package com.atqicat.txt;

import com.atqicat.Config.SpringConfig;
import com.atqicat.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpringConfig.class)
public class SpringTxt {
    @Autowired
    public StudentService studentService;
    @Test
    public void text1(){
        studentService.UpdateNameById();
    }
}
