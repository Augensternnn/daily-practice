package reflect;

import java.lang.reflect.Method;

@Pro(className = "domain.Person",methodName = "work")
public class Reflect2 {
    public static void main(String[] args) throws Exception {
        Class<Reflect2> reflectClass = Reflect2.class;
        Pro an = reflectClass.getAnnotation(Pro.class);
        String className = an.className();
        String methodName = an.methodName();
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
