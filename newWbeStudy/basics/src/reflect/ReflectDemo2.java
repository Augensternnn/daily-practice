package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    /**
     Class对象功能：
     * 获取功能：
     1. 获取成员变量们
     * Field[] getFields()
     * Field getField(String name)

     * Field[] getDeclaredFields()
     * Field getDeclaredField(String name)

     2. 获取构造方法们
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(类<?>... parameterTypes)

     * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     * Constructor<?>[] getDeclaredConstructors()

     3. 获取成员方法们：
     * Method[] getMethods()
     * Method getMethod(String name, 类<?>... parameterTypes)

     * Method[] getDeclaredMethods()
     * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     4. 获取类名
     * String getName()

     */

    public static void main(String[] args) throws Exception {
        //0.获取Person的Class对象
        Class personClass = Person.class;

        System.out.println("============1===========");
        /**
         * 1. 获取成员变量们
         */
        //Field[] getFields()：获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for(Field field : fields){
            System.out.println(field);
        }
        System.out.println("------------");

        //Field getField(String name)：获取指定名称的public修饰的成员变量
        Field a = personClass.getField("a");
            //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
            //设置a的值
        a.set(p,"哈哈");
        System.out.println(p);
        System.out.println("------------");

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field declaredField : declaredFields){
            System.out.println(declaredField);
        }
        System.out.println("------------");

        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
            //忽略访问权限修饰符的安全检查
        d.setAccessible(true);  //暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

        System.out.println("============2===========");
        /**
         * 2. 获取构造方法们
         */
        //Constructor<T> getConstructor(类<?>... parameterTypes)
            //有参
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
                //创建对象
        Object person = constructor.newInstance("哈哈", 21);
        System.out.println(person);
        System.out.println("------------");
            //空参
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
                //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);
        //空参构造方法创建对象可简化为：
        Object o = personClass.newInstance();
        System.out.println(o);
        //constructor1.setAccessible(true);

        System.out.println("============3===========");
        /**
         * 3. 获取成员方法们
         */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Method eat_method2 = personClass.getMethod("eat", String.class);
        Person p1 = new Person();
            //执行方法
        eat_method.invoke(p1);
        eat_method2.invoke(p1,"饭");
        System.out.println("------------");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for(Method method : methods){
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            //method.setAccessible(true);
        }

        System.out.println("============4===========");
        /**
         * 4. 获取类名
         */
        String className = personClass.getName();
        System.out.println(className);
    }



}
