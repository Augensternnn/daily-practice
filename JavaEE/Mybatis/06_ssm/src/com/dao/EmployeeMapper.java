package com.dao;

import com.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    List<Employee> getEmps();
}
