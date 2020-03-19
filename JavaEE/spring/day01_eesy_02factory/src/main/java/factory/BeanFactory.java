package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂，即 创建service和dao对象的
 *
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：用Java语言编写的可重用组件
 *      javabean ≠ 实体类  [JavaBean范围 ＞ 实体类]
 *      实体类只是可重用组件的一部分，业务层、持久层都可以看成可重用组件
 *
 *如何创建Bean对象的工厂：
 *      1.需要一个配置文件，来配置我们的service和dao    [配置文件可以是xml，也可以是properties，(properties在解析、读取时相对xml简单)]
 *          配置的内容：唯一标识=全限定类名 (key=value)
 *      2.通过读取配置文件中配置的内容，反射创建对象
 *
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;

    //定义一个Map，用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败...");
        }
    }

    /**
     * 根据bean的名称获取对象(单例的)
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
