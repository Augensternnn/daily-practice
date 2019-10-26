import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.getConnection();

            // PreparedStatement：下标从 1 开始；  安全性、性能比 Statement 更高，因为SQL语句会预编译在数据库系统
            // ?为占位符，一行中可以有多个占位符
            String sql = "insert into student(sn, name, qq_mail, classes_id) values (????)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,3232);
            ps.setString(2,"张三");
            ps.setString(3,"zhangsan@qq.com");
            ps.setInt(4, 1);
            int num = ps.executeUpdate();
            if(num > 0){
                System.out.println("插入成功：" + num);
            }else {
                throw new RuntimeException("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, ps, null);
            // DBUtil.close(connection, ps);
        }
    }
}

