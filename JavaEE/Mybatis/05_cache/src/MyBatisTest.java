import bean.Department;
import bean.Employee;
import dao.*;
import org.apache.ibatis.cache.Cache;
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
     *       效果：数据会从二级缓存中获取
     *       【注】查出的数据都会被默认先放在一级缓存中，
     *            只有会话提交或关闭后，一级缓存中的数据才会转移到二级缓存中
     *
     *      使用步骤：
     *          1.开启全局二级缓存配置：<setting name="cacheEnabled" value="true"/>
     *          2.去mapper.xml中配置使用二级缓存：<cache></cache>  (在哪个mapper下写了cache，哪个mapper下才有二级缓存)
     *          3.我们的POJO需要实现序列化接口
     *
     *和缓存有关的设置/属性：
     *          1.cacheEnabled：
     *              true：开启缓存  [默认值]
     *              false：关闭缓存  [关闭二级缓存，一级缓存一直可用]
     *          2.每个select标签都有useCache属性：对一级缓存无影响
     *              true：使用缓存
     *              false：不使用缓存  [二级缓存不可使用，一级缓存依然可使用]
     *          3.【每个增删改标签的flushCache默认都为true，即 增删改执行完成后就会清除缓存(一级二级都会清除)】
     *              flushCache="true"：一级缓存清空，二级缓存也会被清空
     *              查询标签的flushCache默认为false，即 查询完成后不会清除缓存
     *                  若flushCache=true：每次查询之后都会清空缓存，缓存是没有被使用的
     *          4.sqlSession.clearCache()：只是清除当前session的一级缓存，和二级缓存没关系
     *              【注】 flushCache：一级二级都会清除
     *                     clearCache()：只是清除一级缓存，和二级缓存无关
     *          5.localCacheScope：本地缓存作用域（影响一级缓存）
     *              SESSION：当前会话的所有数据保存在会话缓存中  [默认值]
     *              STATEMENT：可以禁用一级缓存[即 没有数据将会在当前会话被共享]
     *
     *第三方缓存整合：
     *      1.导入第三方缓存包
     *      2.导入与第三方缓存整合的适配包(官方有)
     *      3.mapper.xml中使用自定义缓存
     *          <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
     */
    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession1 = sqlSessionFactory.openSession();
        try {
            //1.
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper1 = openSession1.getMapper(EmployeeMapper.class);

            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
            openSession.close();

            //第二次查询：从二级缓存中拿到的数据，并没有发送新的sql
            Employee emp1 = mapper1.getEmpById(1);
            System.out.println(emp1);
            openSession1.close();
        }finally {
            
        }
    }

    @Test
    public void testSecondLevelCache2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();
        try{
            //1、
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            DepartmentMapper mapper2 = openSession2.getMapper(DepartmentMapper.class);

            Department deptById = mapper.getDeptById(1);
            System.out.println(deptById);
            openSession.close();

            openSession.clearCache();

            Department deptById2 = mapper2.getDeptById(1);
            System.out.println(deptById2);
            openSession2.close();
            //第二次查询是从二级缓存中拿到的数据，并没有发送新的sql

        }finally{

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
