package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 写一个"框架"，在不能改变该类的任何代码的前提下，
 * 可以帮我们创建任意类的对象，并且执行其中任意方法
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        ClassLoader classLoader = Reflect.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("reflect.properties");
        pro.load(is);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName,String.class);
        method.invoke(obj,"米饭");
    }
}
