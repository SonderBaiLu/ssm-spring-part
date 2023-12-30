package com.qicat.Mybatis;

import com.atqicat.Mapper.EmployeeMapper;
import com.atqicat.pojp.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Text {
    @Test
    public void textSelectEmployee() throws IOException {
        //1.读取外部配置文件(mybatis-config.xml)
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3.根据sqlSessionFactory 每次业务创建一个用完就释放
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4 获取接口的代理对象（代理技术） 调用代理对象的方法，就会查找mapper接口方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee:" + employee);
        //5. 提交事务非DQL和释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
