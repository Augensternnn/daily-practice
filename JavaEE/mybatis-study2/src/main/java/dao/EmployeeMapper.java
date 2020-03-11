package dao;

import bean.Employee;

public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    //public void addEmp(Employee employee);
    public Long addEmp(Employee employee);

    //public void updateEmp(Employee employee);
    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
