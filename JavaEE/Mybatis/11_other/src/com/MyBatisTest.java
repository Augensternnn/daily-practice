package com;

import com.bean.EmpStatus;
import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "com/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //分页
            Page<Object> page = PageHelper.startPage(5, 2);

            List<Employee> emps = mapper.getEmps();
            //使用PageInfo包装查询后的emps  【PageInfo：可以获取更详细的分页信息】
//            PageInfo<Employee> info = new PageInfo<>(emps);
            //传入要连续显示多少页
            PageInfo<Employee> info = new PageInfo<>(emps, 5);

            for (Employee emp : emps) {
                System.out.println(emp);
            }

            /*System.out.println("当前页码："+page.getPageNum());
            System.out.println("总记录数："+page.getTotal());
            System.out.println("每页的记录数："+page.getPageSize());
            System.out.println("总页码："+page.getPages());*/
            System.out.println("当前页码："+info.getPageNum());
            System.out.println("总记录数："+info.getTotal());
            System.out.println("每页的记录数："+info.getPageSize());
            System.out.println("总页码："+info.getPages());
            System.out.println("是否是第一页："+info.isIsFirstPage());
            System.out.println("是否是最后一页"+info.isIsLastPage());
            System.out.println("连续显示的页码：");
            int[] nums = info.getNavigatepageNums();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        } finally {
            openSession.close();
        }
    }

    /**
     * 测试批量操作
     */
    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //可以执行批量操作的sqlSession
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        long start = System.currentTimeMillis();//开始时间
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            for (int i = 0; i < 10000; i++) {
                mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0,5),"b","1"));
            }
            openSession.commit();
        }finally {
            openSession.close();
            long end = System.currentTimeMillis();//结束时间
            //批量：（ 预编译sql一次 -> 设置参数10000次 -> 执行1次 ）
            //Parameters: 616c1(String), b(String), 1(String)==>4598
            //非批量：（预编译sql->设置参数->执行）==》执行10000次    10200
            System.out.println("执行时长："+(end-start));
        }
    }

    @Test
    public void testEnumUse(){
        EmpStatus login = EmpStatus.LOGIN;
        System.out.println("枚举的索引："+login.ordinal());
        System.out.println("枚举的名字："+login.name());

        System.out.println("枚举的状态码："+login.getCode());
        System.out.println("枚举的提示消息："+login.getMsg());
    }

    /**
     * 默认mybatis在处理枚举对象的时候保存的是枚举的名字：EnumTypeHandler
     * 改变使用：EnumOrdinalTypeHandler：
     * @throws IOException
     */
    @Test
    public void testEnum() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee("test_enum", "enum@qq.com","1");
            /*mapper.addEmp(employee);
            System.out.println("保存成功"+employee.getId());
            openSession.commit();*/
            Employee empById = mapper.getEmpById(20025);
            System.out.println(empById.getEmpStatus());
        }finally{
            openSession.close();
        }
    }
}
