package com.atqicat.service.impl;

import com.atqicat.dao.StudentDao;
import com.atqicat.pojo.Student;
import com.atqicat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        List<Student> stringList = studentDao.queryAll();
        return stringList;
    }
}
