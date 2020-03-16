import bean.Department;
import bean.Employee;
import dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 两级缓存：
     *  一级缓存[本地缓存]：sqlSession级别的缓存；一级缓存是一直开启的，无法关闭；sqlSession级别的一个map
     *      与数据库同一次会话期间查询到的数据会放在本地缓存中
     *      之后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库
     *
     *      【一级缓存的失效情况】：即 没有使用到当前一级缓存的情况(结果就是:还需要再向数据库发出查询)
     *          1.sqlSession不同
     *          2.sqlSession相同，查询条件不同：
     *              失效：因为当前一级缓存中还没有这个数据
     *              有效：一级缓存中已经有该数据
     *          3.sqlSession相同，两次查询之间执行了增删改操作
     *              失效：因为这次增删改可能对当前数据有影响
     *          4.sqlSession相同，手动清除了一级缓存(缓存清空)
     *
     *  二级缓存[全局缓存]：基于namespace级别的缓存；一个namespace对应一个二级缓存
     *      工作机制：
     *          1.一个会话查询一条数据：这个数据就会被放在当前会话的一级缓存中(只要该会话没关，再去查询相同数据会去一级缓存中拿)
     *          2.如果会话关闭(该会话对应的一级缓存就没有了)：
     *              一级缓存中的数据会被保存到二级缓存中，新的会话查询信息就可以参照二级缓存中的内容
     *          3.sqlSession --> EmployeeMapper --> Employee
     *                       --> DepartmentMapper --> Department
     *              不同namespace查出的数据会放在自己对应的缓存中(map)
     *
     *      使用步骤：
     *          1.开启全局二级缓存配置：<setting name="cacheEnabled" value="true"/>
     *          2.去mapper.xml中配置使用二级缓存：<cache></cache>
     *          3.我们的POJO需要实现序列化接口
     */
    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        }finally {
            openSession.clearCache();
        }
    }

    @Test
    public void testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee emp01 = mapper.getEmpById(1);
            System.out.println(emp01);

            //1.sqlSession不同
//            SqlSession openSession1 = sqlSessionFactory.openSession();
//            EmployeeMapper mapper1 = openSession1.getMapper(EmployeeMapper.class);

            //2.sqlSession相同，查询条件不同
//            Employee emp02 = mapper.getEmpById(3);

            //3.sqlSession相同，两次查询之间执行了增删改操作
//            mapper.addEmp(new Employee(null,"testCache","Cache@qq.com","1"));
//            System.out.println("数据添加成功...");
//            Employee emp02 = mapper.getEmpById(1);

            //4.sqlSession相同，手动清除了一级缓存(缓存清空)
            openSession.clearCache();
            Employee emp02 = mapper.getEmpById(1);

            System.out.println(emp02);
            System.out.println(emp01==emp02);

//            openSession1.close();
        }finally {
            openSession.close();
        }
    }
}
