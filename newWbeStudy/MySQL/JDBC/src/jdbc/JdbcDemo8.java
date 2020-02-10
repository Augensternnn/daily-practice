package jdbc;

import doMain.Book;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询book表的数据将其封装为对象，然后装载集合，返回。
 */
public class JdbcDemo8 {
    public static void main(String[] args) {
        List<Book> list = new JdbcDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 查询所有book对象
     * @return
     */
    public List<Book> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Book> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///ebook","root","754683");
            //3.定义SQL语句
            String sql = "select * from book";
            //4.获取执行SQL的对象
            stmt = conn.createStatement();
            //5.执行SQL
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Book book = null;
            list = new ArrayList<Book>();
            while (rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int category_id = rs.getInt("category_id");
                //创建book对象，并赋值
                book = new Book();
                book.setId(id);
                book.setName(name);
                book.setAuthor(author);
                book.setPrice(price);
                book.setCategory_id(category_id);
                //装载集合
                list.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 演示JDBC
     * @return
     */
    public List<Book> findAll2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Book> list = null;
        try {
            /*//1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///ebook","root","754683");*/
            conn = JdbcUtils.getConnection();
            //3.定义SQL语句
            String sql = "select * from book";
            //4.获取执行SQL的对象
            stmt = conn.createStatement();
            //5.执行SQL
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Book book = null;
            list = new ArrayList<Book>();
            while (rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int category_id = rs.getInt("category_id");
                //创建book对象，并赋值
                book = new Book();
                book.setId(id);
                book.setName(name);
                book.setAuthor(author);
                book.setPrice(price);
                book.setCategory_id(category_id);
                //装载集合
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
            JdbcUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
