package com.atqicat.controller;

import com.atqicat.pojo.Student;
import com.atqicat.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void finAll(){
        List<Student> all = studentService.findAll();
        System.out.println("最终查到的数据是：" + all);
    }
}
