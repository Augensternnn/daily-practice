package _01_HelloWorld.test;

import _01_HelloWorld.bean.Employee;
import _01_HelloWorld.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

/**
 * 1.接口式编程
 *      原生：     Dao  -->  DaoImpl
 *      mybatis：  Mapper  -->  xxMapper.xml
 * 2.SqlSession代表和数据库的一次会话；用完必须关闭
 * 3.SqlSession和connection一样，都是非线程安全[不可以将SqlSession写成成员变量]，每次使用都应该去获取新的对象
 * 4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
 *      将接口和xml进行绑定
 *      EmployeeMapper empMapper = SqLSession.getMapper(Employee.class);
 * 5.两个重要的配置文件：
 *      mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...很多 系统运行环境信息
 *      sql映射文件：保存了每一个sql语句的映射信息；[可以没有全局配置文件，但映射文件一定要有]
 *                  将sql抽取出来
 */
public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "_01_HelloWorld/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 1.写全局配置文件：有数据源一些运行环境信息
     *      根据xml文件[全局配置文件]创建一个SqlSessionFactory对象
     * 2.写sql映射文件：配置了每一个sql，以及sql的封装规则等
     * 3.将sql映射注册在全局配置文件中
     * 4.写代码：
     *      1）根据全局配置文件得到SQLSessionFactory
     *      2）使用SQLSessionFactory工厂，获取到SQLSession对象，使用它来执行增删改查
     *          一个SQLSession就是代表和数据库的一次会话，【注】用完要关闭
     *      3）使用sql的唯一标识来告诉MyBatis执行那个sql，sql都是保存在sql映射文件中的
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession session = sqlSessionFactory.openSession();
        try {
            /**
             * selectOne()：
             *  参数1：sql的唯一标识[推荐：namespace+id，以防有同名不同路径的文件]；Unique identifier matching the statement to use.
             *  参数2：执行sql要用的参数；A parameter object to pass to the statement.
             */
//            Employee employee = session.selectOne("org.mybatis.EmployeeMapper.selectEmp", 1);
            Employee employee = session.selectOne("_01_HelloWorld.dao.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

    @Test
    public void test01() throws IOException {
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
}
