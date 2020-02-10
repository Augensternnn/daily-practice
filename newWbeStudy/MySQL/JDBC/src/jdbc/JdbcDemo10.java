package jdbc;

import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事物操作
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取数据库连接
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            //2.定义SQL
            //2.1 张三 - 500
            String sql1 = "update account set balance=balance-? where id=?";
            //2.2 李四 + 500
            String sql2 = "update account set balance=balance+? where id=?";
            //3.获取执行SQL对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行SQL
            pstmt1.executeUpdate();

            //手动制造异常
            int i = 3/0;

            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn!=null)
                    conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt1,conn);
            JdbcUtils.close(pstmt2,null);
        }
    }
}
