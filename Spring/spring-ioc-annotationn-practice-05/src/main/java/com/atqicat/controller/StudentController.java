package com.atqicat.controller;

import com.atqicat.pojo.Student;
import com.atqicat.service.StudentService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService  studentService;
    public void findAll(){
        List<Student> studentList = studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
}
