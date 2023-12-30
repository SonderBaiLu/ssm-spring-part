package atqicat.service.Impl;
import atqicat.dao.StudentDao;
import atqicat.pojo.Student;
import atqicat.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    //Service层 注入 Dao
    @Resource(name = "studentDaoUmpl")
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("Service" +studentList);
        return studentList;
    }
}
