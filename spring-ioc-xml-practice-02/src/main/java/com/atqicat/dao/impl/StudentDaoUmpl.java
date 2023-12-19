package com.atqicat.dao.impl;

import com.atqicat.dao.StudentDao;
import com.atqicat.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoUmpl implements StudentDao {
    // 注入JDBC Templated 对象
    private JdbcTemplate jdbcTemplate;
    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        // jdbc Template进行数据库的查询
        String sql = "select id,name,gender,age,class as classes from students ";
        List<Student> studentQueryListAll = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("Dao" + studentQueryListAll);
        return studentQueryListAll;
    }
}
