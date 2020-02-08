package annotation;

import java.util.Date;

/**
 * JDK中预定义的一些注解
 * 		* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
 * 		* @Deprecated：该注解标注的内容，表示已过时，不建议用了，但是也还能用
 * 		* @SuppressWarnings：压制警告
 */
@SuppressWarnings("all")    //写在类上，关于类的所有警告都没有了；写在某一方法上，关于该方法的所有警告都没有了
public class AnnoDemo2 {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }
    //@SuppressWarnings("all")
    public void show2(){
        //替代show1()
    }
    public void demo(){
        show1();
        Date date = new Date();
    }
}
