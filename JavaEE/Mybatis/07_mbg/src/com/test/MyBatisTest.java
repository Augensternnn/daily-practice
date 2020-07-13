package com.test;

import com.bean.Employee;
import com.bean.EmployeeExample;
import com.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "com/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testMyBatis3_1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.selectByExample(null);
            for (Employee employee : list) {
                System.out.println(employee.getId());
            }
        }finally {
            openSession.close();
        }
    }

    @Test
    public void testMyBatis3_2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //xxxExample就是封装查询条件的
            //1.查询所有
//            List<Employee> emps = mapper.selectByExample(null);//没有条件可以传null

            //2、查询员工名字中有e字母的，和员工性别是1的
            //封装员工查询条件的example
            EmployeeExample example = new EmployeeExample();
            /* 创建一个Criteria，这个Criteria就是拼装查询条件
            select id, last_name, email, gender, d_id from tbl_employee
            WHERE ( last_name like ? and gender = ? ) or email like "%e%"
            */
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%e%");
            criteria.andGenderEqualTo("1");

            EmployeeExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailLike("%e%");
            example.or(criteria1);
            List<Employee> emps = mapper.selectByExample(example);

            for (Employee emp : emps) {
                System.out.println(emp.getId());
            }
        }finally {
            openSession.close();
        }
    }
}
