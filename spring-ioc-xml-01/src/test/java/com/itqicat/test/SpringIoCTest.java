package com.itqicat.test;

import com.itqicat.ioc_03.A;
import com.itqicat.ioc_03.HappyCompoent;
import com.itqicat.ioc_05.javaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    // 如何创建Ioc容器 ， 并且读取配置文件
    public void createIoc(){
        /*
        * 最大接口: BeanFactory
        * 扩展接口: ApplicationContext
        * 基于ApplicationContext接口实现类:
        *   ClassPathXmlApplicationContext 读取类路径下的XML配置方式 classes
        *   FileSystemXmlApplicationContext 读取指定文件位置的XML配置方式
        *   AnnotationConfigApplicationContext 读取配置类方式的ioc容器
        *   WebApplicationContest  读取web项目专属的ioc容器
        * */
        // 创建容器(String...配置文件)可以填写一个或者多个【】
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        // 方式二 先创建ioc容器对象 在指定配置文件 后 刷新
        // 源码的配置过程！ 创建容器[spring] 和 配置文件指定分开[配置文件自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml"); // 外部配置文件设置
        applicationContext1.refresh(); // 调用ioc和di的流程 刷新
    }
    // 如何在IOC 容器中获取组件Bean
    @Test
    public void getBenFrom(){
        // 创建 IOC 容器
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml"); // 外部配置文件设置
        applicationContext1.refresh(); // 调用ioc和di的流程 刷新
        // 2 读取IOC 容器的组件
        //方案一 直接根据bean ID 获取  返回值类型是Object 这种方式需要强制转换[不推荐]
        HappyCompoent happyCompoent = (HappyCompoent) applicationContext1.getBean("HappyCompoent");
        //方案二 根据Bean ID 同时指定bean的类型Class
        HappyCompoent happyCompoent1 = applicationContext1.getBean("HappyCompoent", HappyCompoent.class);
        //方案三 直接根据类型获取 Bean
        //TODO 根据Bean的类型获取,同一个类型 在IOC容器中只能有一个Bean
        //TODO 如果ioc容器中存在多个同类型的bean 会出现 NoUniquBeanDefinitionExecption
        //TODO ioc配置一定是实现类，但是也可以通过接口类型获取值 getBean(类型); instanceof ioc容器的类型 == true
        //TODO instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型
        A bean = applicationContext1.getBean(A.class);
        bean.doWork();
    }
    @Test
    public void test_04(){
        // 测试IOC配置的初始化和销毁的触发
        ClassPathXmlApplicationContext app1 =
                new ClassPathXmlApplicationContext("spring-04.xml");
        // ioc容器调用destroy
        // ioc会礼记释放死掉！
        // 正常结束ioc容器
        app1.close();
    }
    @Test
    public void test_05(){
        // 读取使用factoryBean工厂配置的组件对象
        ClassPathXmlApplicationContext app1 =
                new ClassPathXmlApplicationContext("spring-04.xml");
        // 读取组件
        javaBean javaBean = app1.getBean("javaFactoryBean", javaBean.class);
        //TODO FactoryBean工厂也会加入IOC容器 他的名字是 &加上ID值
        System.out.println("javabean = " + javaBean);
        Object bean = app1.getBean("&javaFactoryBean");

    }
}
