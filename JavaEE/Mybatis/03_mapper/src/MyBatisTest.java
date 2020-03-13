import bean.Employee;
import dao.EmployeeMapper;
import dao.EmployeeMapperAnnotation;
import dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws IOException {
        //1.获取SQLSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2.获取SQLSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.获取接口的实现类对象
            //将接口和xml进行动态绑定，mybatis会为接口自动创建一个代理对象，代理对象去执行增删改查
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);//mapper：代理对象[class com.sun.proxy.$Proxy4]
            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper.getClass());
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    /**
     * mapper、class，注册接口
     * EmployeeMapperAnnotation
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
        }finally {
            openSession.close();
        }
    }

    /**
     * 测试增删改
     * 1.mybatis允许增删改直接定义以下类型的返回值：
     *      Integer、Long、Boolean以及其基本类、包装类
     * 2.需要手动提交数据
     *      sqlSessionFactory.openSession(); --> 手动提交
     *      sqlSessionFactory.openSession(true); --> 自动提交
     */
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1.获取到的openSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            //添加测试
            Employee employee = new Employee(null,"xixi","xixi@qq.com","0");
            mapper.addEmp(employee);
            System.out.println(employee.getId());

            //修改测试
            /*Employee employee = new Employee(3,"jack","jack@qq.com","0");
            boolean updateEmp = mapper.updateEmp(employee);
            System.out.println(updateEmp);*/

            //删除测试
            /*mapper.deleteEmpById(2);*/

            //2.手动提交
            openSession.commit();
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1.获取到的openSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //Employee employee = mapper.getEmpByIdAndLastName(1, "tom");

            /*Map<String,Object> map = new HashMap<>();
            map.put("id",1);
            map.put("lastName","Tom");
            map.put("tableName","tbl_employee");
            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);*/

            /*List<Employee> like = mapper.getEmpsByLastNameLike("%e");
            for (Employee employee : like) {
                System.out.println(employee);
            }*/

            /*Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
            System.out.println(map);*/

            Map<Integer, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%r%");
            System.out.println(map);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);

            /*Employee empById = mapper.getEmpById(1);
            System.out.println(empById);*/

           /* Employee empAndDept = mapper.getEmpAndDept(1);
            System.out.println(empAndDept);
            System.out.println(empAndDept.getDept());*/

            Employee empByIdStep = mapper.getEmpByIdStep(1);
            System.out.println(empByIdStep);
            System.out.println(empByIdStep.getDept());
        }finally {
            openSession.close();
        }
    }
}
