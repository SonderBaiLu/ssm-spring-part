package com.atqicat.service.Impl;

import com.atqicat.dao.StudentDao;
import com.atqicat.pojo.Student;
import com.atqicat.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //Service层 注入 Dao
    private StudentDao  studentDao;
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("Service" +studentList);
        return studentList;
    }
}
