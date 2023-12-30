package atqicat.controller;



import atqicat.pojo.Student;
import atqicat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
// 1. 标记注解 @Component
// 2. 配置扫描包
@Controller//写上他相当于 <bean id="StudentController" class="StudentController"> 默认的
public class StudentController {
    // Autowired 可以多个装配-使用属性名装配
    @Autowired
    @Qualifier(value = "studentServiceImpl")
    private StudentService studentService;

    public void finAll(){
        List<Student> all = studentService.findAll();
        System.out.println("最终查到的数据是：" + all);
    }
}
