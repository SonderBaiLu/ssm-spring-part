package com.atqicat.Mapper;

import com.atqicat.pojp.Employee;

public interface EmployeeMapper {
    //根据ID 查询员工信息
    Employee queryById(Integer id);
    int deleteById(Integer id);
}
