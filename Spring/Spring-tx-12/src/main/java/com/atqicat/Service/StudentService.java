package com.atqicat.Service;

import com.atqicat.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
// 隔离级别设置 推荐设置第二个隔离级别
// Isolation.READ_COMMITTED
@Service
@Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED) // 添加事务
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    // 指定异常回滚和指定异常不会滚
    //默认情况下，指定异常发生运行时异常才会回滚
    //指定Exception异常来控制所有异常都回滚
    //在回滚的异常范围内 控制某个异常不回滚
    // noRollbackFor
    @Transactional(readOnly = true)
    public void UpdateNameById() throws FileNotFoundException {
        studentDao.UpdateNameById("他的",1);
        new FileInputStream("xxxx");
    }
}
