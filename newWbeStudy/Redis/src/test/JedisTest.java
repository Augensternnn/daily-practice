package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作(调用对应的方法)
        jedis.set("username","zhangsan");
        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * string 数据结构操作
     */
    @Test
    public void test2(){
        //1.获取连接
        Jedis jedis = new Jedis();//空参构造，默认值 "localhost",6379端口
        //2.操作
        jedis.set("username","zhangsan");//存储
        String username = jedis.get("username");//获取
        System.out.println(username);

        //setex()方法：存储可以指定过期时间的 key value
        jedis.setex("activecode",20,"haha");//将activecode：haha键值对存入redis，并且20秒后自动删除该键值对

        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * hash 数据结构操作
     */
    @Test
    public void test3(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作

        //存储
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        //keyset遍历结合
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }

        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * list 数据结构操作
     */
    @Test
    public void test4(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        //存储
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","a","b","c");//从右边存

        //范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //弹出
        String element = jedis.lpop("mylist");
        System.out.println(element);
        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        //范围获取
        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);
        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * set 数据结构操作
     */
    @Test
    public void test5(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        //存储
        jedis.sadd("myset","java","php","c++");

        //获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * sortedset 数据结构操作
     */
    @Test
    public void test6(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        //存储
        jedis.zadd("mysortedset",3,"张三");
        jedis.zadd("mysortedset",30,"李四");
        jedis.zadd("mysortedset",25,"王五");

        //获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);

        //3.释放资源(关闭连接)
        jedis.close();
    }

    /**
     * Jedis连接池使用
     */
    @Test
    public void test7(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);//最大允许连接数
        config.setMaxIdle(10);//最大空闲连接

        //1.创建Jedis连接池对象
//        JedisPool jedisPool = new JedisPool();
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("haha","aaa");

        //4.关闭 -- 归还连接到连接池中
        jedis.close();
    }

    /**
     * jedis连接池工具类使用
     */
    @Test
    public void test8(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        //3. 使用
        jedis.set("hello","world");

        //4. 关闭 归还到连接池中
        jedis.close();;
    }
}
