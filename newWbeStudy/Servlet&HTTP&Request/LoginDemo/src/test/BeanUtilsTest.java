package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        try {
            //BeanUtils.setProperty(user,"gender","male");//gender为成员变量
            BeanUtils.setProperty(user,"hehe","male");//hehe为属性
            System.out.println(user);

            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
