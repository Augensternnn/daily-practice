package DEMO;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class DBUtilTest {
    @Test
    public void testConnection(){
        Connection connection = DBUtil.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void testSelectScore(){
        // Assert.assertNotNull(null);
        List<Score> list = new Select().selectScore(60, 1);
        System.out.println(list);
        Assert.assertTrue(list.size() == 9);
    }

    @Test
    public void testSelectScore2(){
        List<Student> list = new Select()
                .selectScore2(60, 1);
        list.forEach(System.out::println);
        Assert.assertTrue(list.size()==5);
    }
}
