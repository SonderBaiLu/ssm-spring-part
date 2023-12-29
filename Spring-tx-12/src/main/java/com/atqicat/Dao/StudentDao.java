package com.atqicat.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void UpdateNameById(String name,Integer id){
        String sql = "update students  set name = ? where  id = ?;";
        int rows = jdbcTemplate.update(sql,name,id);
    }
}
