package dao;

import bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {
    public Employee getEmpByMap(Map<String,Object> map);

    //public Employee getEmpByIdAndLastName(Integer id,String lastName);
    public Employee getEmpByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

    public Employee getEmpById(Integer id);

    //public void addEmp(Employee employee);
    public Long addEmp(Employee employee);

    //public void updateEmp(Employee employee);
    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
