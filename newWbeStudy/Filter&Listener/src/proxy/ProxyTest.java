package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        //2.动态代理增强lenovo对象
        /*
         三个参数：
            参数1(类记载器)：真实对象.getClass().getClassLoader()
            参数2(接口数组，保证了代理对象、真实对象实现相同的接口)：真实对象.getClass().getInterfaces()
            参数3(处理器)： new InvocationHandler() {}
        Proxy.newProxyInstance()返回：代理对象
        因为代理对象、真实对象实现相同接口，故返回的Object可以强转为接口类型
         */
        SaleComputer proxy_lenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
                代理逻辑编写的方法：增强代理逻辑会在这个方法里面执行
                    特点：代理对象调用的所有方法都会触发该方法执行
                三个参数：
                    proxy：代理对象[一般不用]       proxy_lenovo
                    method：代理对象调用的方法被封装为的对象
                    args：代理对象调用方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("invoke方法执行了...");
                System.out.println(method.getName());
                System.out.println(args[0]);*/
                /*
                增强方式：
					1. 增强参数列表：方法有参数才有必要增强
					2. 增强返回值类型：
					3. 增强方法体执行逻辑
                 */
                //判断是否是sale()
                if(method.getName().equals("sale")){
                    //1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接你...");
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货...");
                    //2.增强返回值
                    return obj + "_鼠标垫";
                }else {
                    //原样调用
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }


                /*//使用真实对象调用该方法
                Object obj = method.invoke(lenovo, args);
                return obj;*/

            }
        });

        //3.调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
//        proxy_lenovo.show();
    }
}
