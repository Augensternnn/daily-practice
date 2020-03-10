package dao;

import bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {

//    @Insert()
    @Select("select * from tbl_employee where id = #{id}")
    public Employee getEmpById(Integer id);
}
