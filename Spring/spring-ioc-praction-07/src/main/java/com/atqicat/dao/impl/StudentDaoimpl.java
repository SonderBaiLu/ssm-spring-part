package com.atqicat.dao.impl;

import com.atqicat.dao.StudentDao;
import com.atqicat.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDaoimpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        String sql = "select id,name,age,gender,class as classes from students;";
        List<Student> studentList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }
}
