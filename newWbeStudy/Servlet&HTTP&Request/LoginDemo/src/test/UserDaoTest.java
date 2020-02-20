package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("zhangsan");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        dao.login(loginuser);

        System.out.println(loginuser);
    }
}
