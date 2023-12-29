package com.atqicat.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.atqicat")
@PropertySource("classpath:jdbc.properties")
// 第二部
@EnableTransactionManagement // 开启事务注解的支持
public class SpringConfig {
    @Value("${at_driver}")
    private String Driver;
    @Value("${at_url}")
    private String Url;
    @Value("${at_username}")
    private String UserName;
    @Value("${at_password}")
    private String Password;
    //druid 连接池实例化
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(Driver);
        dataSource.setUrl(Url);
        dataSource.setUsername(UserName);
        dataSource.setPassword(Password);
        return  dataSource;
    }
    @Bean
    public JdbcTemplate template(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return  jdbcTemplate;
    }
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        // 第一步 new对象
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        // 他需要连接池对象
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
