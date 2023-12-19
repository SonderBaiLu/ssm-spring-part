package com.atqicat.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atqicat.controller.StudentController;
import com.atqicat.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    /*
    * JdbcTemplate 简化数据库的crud 不提供连接池
    * DruidDataSource 负责连接池的创建和数据库驱动的注册
    * */
    @Test
    public void testForJava(){
        // 创建有个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/stem");// url地址 // 如果是 localhost和3306端口 直接写///就行 如果不是需要 "jdbc:mariadb://localhost:3306/dbName"
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver"); // jdbc驱动
        dataSource.setUsername("root");
        dataSource.setPassword("Wsqz$443");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        // 查询
        String sql = "select * from students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                // rs 结果集  rowNum是行数  rs 结果集中获取列的值 赋值给实体类
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 1);

        System.out.println(student.getId() + "---" + student.getName() +"---"+ student.getGender() +"---"+ student.getClasses());

    }
    @Test
    public void testForIoc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        String sql = "insert into students (name,gender,age,class) values (?,?,?,?)";
//        参数一 String类型的sql语句可以带占位符 ?? 只能替代值 不能替代关键字和容器名
//        参数二 Object param 传入占位字符值 顺序从左开始
//        返回值 int 影响函数
        int row =  jdbcTemplate.update(sql,"胡桃","女","18","原神");
        System.out.println(row);
        // 查询
        sql = "select * from students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                // rs 结果集  rowNum是行数  rs 结果集中获取列的值 赋值给实体类
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setClasses(rs.getString("class"));
                return student;
            }
    }); // cnm sb rnm sb
}

    // 从ioc 容器中获取controller 并且调用业务
    @Test
    public void testQeryAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-02.xml");
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.finAll();
        applicationContext.close();

        }
}
