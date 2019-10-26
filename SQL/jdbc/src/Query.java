import java.sql.*;

public class Query {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.getConnection();

            // PreparedStatement：下标从 1 开始；  安全性、性能比 Statement 更高，因为SQL语句会预编译在数据库系统
            // ?为占位符，一行中可以有多个占位符
            String sql = "select * from student where qq_mail " +
                    "like ? and classes_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com");
            ps.setInt(2, 1);
            rs = ps.executeQuery();

            /*
            // SQL注入、SQL漏洞
            // Statement
            String sql = "select * from student where id = 3";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

             */

            while (rs.next()){
                Integer id = rs.getInt("id");
                Integer sn = rs.getInt("sn");
                System.out.println(String.format("id = %s ,sn = %s", id, sn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, ps, rs);
        }
    }
}
