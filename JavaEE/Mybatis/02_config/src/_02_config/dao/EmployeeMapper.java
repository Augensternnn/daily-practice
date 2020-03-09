package _01_HelloWorld.dao;


import _01_HelloWorld.bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
