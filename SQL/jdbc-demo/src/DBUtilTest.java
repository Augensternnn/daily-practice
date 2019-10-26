import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class DBUtilTest {

    @Test
    public void testConnection(){
        Connection connection = DBUti_2.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void testSelectScore(){
//        Assert.assertNotNull(null);
        List<Score> list = new Select()
                .selectScore(60, 1);
        System.out.println(list);
        Assert.assertTrue(list.size()==9);
    }

    @Test
    public void testSelectScore2(){
        List<Student> list = new Select()
                .selectScore2(60, 1);
        System.out.println(list.size());
//        Assert.assertTrue(list.size()==9);
    }
}
