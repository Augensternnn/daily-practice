package DEMO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    // localhost：数据库服务器所在的IP
    private static final String URL = "jdbc:mysql://localhost:3306/test1014";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "754683";

    private static MysqlDataSource DATASOURCE = new MysqlDataSource();
    static {
        DATASOURCE.setUrl(URL);
        DATASOURCE.setUser(USER_NAME);
        DATASOURCE.setPassword(PASSWORD);
    }

    /*
    封装一个返回值为 Connection 的方法，来获取数据库连接
    1. Class.forName("com.mysql.jdbc.Driver");
       DriverManager.getConnection();

    2. DataSource:
     */
    public static Connection getConnection(){
        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }

    /**
     * 释放资源
     * @param connection    数据库连接
     * @param ps    数据库操作对象
     * @param rs    操作结果集
     */
    public static void close(Connection connection, PreparedStatement ps, ResultSet rs){
        try{
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(connection != null)
                connection.close();
        }catch (SQLException e){
            throw new RuntimeException("释放数据库资源错误");
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
