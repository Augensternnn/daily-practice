import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUti_1 {
    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "754683";

    /**
     * 1.加载驱动：Class.forName("com.mysql.jdbc.Driver")		初始化/加载 com.mysql.jdbc.Driver 这个类，返回一个 class<com.mysql.jdbc.Driver> 对象
     * 2.建立连接：DriverManager.getConnection()
     * 3.创建执行对象Statement：connection.createStatement();
     * 4.执行sql
     * 5.处理结果集ResultSet：while(resultSet.next()){}
     * 6.释放资源：连接(connection)、执行对象(Statement)、结果集对象(ResultSet)要释放，在finally里释放
     【注】创建的时候：先创建连接，再创建执行语句对象，最后创建结果集对象；
     关闭的时候要反过来：先关闭结果集对象，再关闭执行语句对象，最后关闭连接；
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                Integer sn = resultSet.getInt("sn");
                String name = resultSet.getString(3);
                String qq = resultSet.getString(4);
                Integer classesId = resultSet.getInt(5);
                System.out.println(String.format("id=%s,sn=%s," +
                                "name=%s,qq=%s,classesId=%s",
                        id, sn, name, qq, classesId));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
