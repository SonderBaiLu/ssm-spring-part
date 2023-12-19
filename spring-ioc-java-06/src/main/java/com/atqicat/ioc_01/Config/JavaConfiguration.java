package com.atqicat.ioc_01.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

/*
* 1.包扫描注解配置
* 2.引用外部的配置文件
* 3.声明第三方依赖的Bean组件
* ----------------------
* 第一步
* 1. 添加Configuration代表我的是配置雷
* */
@ComponentScan({"com.atqicat.ioc_01"}) // 包扫描注解配置
@PropertySource(value = "classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {
    @Value("${atqicat.url}")
    private String url;
    @Value("${atqicat.driver}")
    private String driver;
    @Value("${atqicat.username}")
    private String username;
    @Value("${atqicat.password}")
    private String password;
    // bean -> 一个方法
    // 方法的返回值类型 == bean组件的类型或者其他的接口和父类
    // 方法的名字 == bean  id
    // 方法体可以自定义实现过程即可
    // 最重要一步 @Bean 会真正让配置类的方法创建的组件存储到ioc容器
    //
    // beanName的问题 默认是：方法名 指定：name|value属性起名字 覆盖方法名
    // 问题2：周期方法如何指定 原有注解方案：PostConstruct + PreDestroy 注解指定
    // bean属性指定： initMethod | destroyMethod指定
    @Bean(name = "egz")
    public DruidDataSource dataSource(){
        // 实现具体的实列过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);//jdbc:mariadb://localhost:3306/stem
        dataSource.setDriverClassName(driver);//org.mariadb.jdbc.Driver
        dataSource.setUsername(username);//root
        dataSource.setPassword(password);//Wsqz$443
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要DataSource
        // 方案一 如果其他组件也是@Bean 可以直接调用
        //jdbcTemplate.setDataSource(d);
        //public JdbcTemplate jdbcTemplate(DataSource d) // 形参列表声明想要的组件类型 可以是一个或者多个 ioc容器也会注入
        //形参变量注入 要求必须有对应的类型组件 如果没有抛异常
        //多个：名字相同就可以,使用逗号可以注入多个
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

}
