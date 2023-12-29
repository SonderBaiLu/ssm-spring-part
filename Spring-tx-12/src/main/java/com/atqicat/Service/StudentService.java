package com.atqicat.Service;

import com.atqicat.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 添加事务
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public void UpdateNameById(){
        studentDao.UpdateNameById("他的",1);
    }
}
