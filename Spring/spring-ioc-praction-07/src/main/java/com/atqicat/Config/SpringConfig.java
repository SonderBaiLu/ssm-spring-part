package com.atqicat.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration // 规定
@PropertySource({"classpath:jdbc.properties"}) // 导入外部配置文件
@ComponentScan({"com.atqicat"}) // 扫描Bean
public class SpringConfig {
    @Value("${at_url}")
    private String url;
    @Value("${at_driver}")
    private String driver;
    @Value("${at_username}")
    private String username;
    @Value("${at_password}")
    private String password;

    @Bean
    public DruidDataSource dataSource(){
        // 实现具体的实列过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    // 使用形参列表
    @Bean
    public DruidDataSource dataSourceTable(@Value("${at_url}") String urlTable, @Value("${at_driver}") String driverTable,
                                           @Value("${at_username}")String usernameTable, @Value("${at_password}")String passwordTable){
        // 实现具体的实列过程
        DruidDataSource dataSourceTable = new DruidDataSource();
        dataSourceTable.setUrl(urlTable);
        dataSourceTable.setDriverClassName(driverTable);
        dataSourceTable.setUsername(usernameTable);
        dataSourceTable.setPassword(passwordTable);
        return dataSourceTable;
    }
    @Bean
    public JdbcTemplate template(DruidDataSource dataSourceTable){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceTable);
        return jdbcTemplate;
    }

}
