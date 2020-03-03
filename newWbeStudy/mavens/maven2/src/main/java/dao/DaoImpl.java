package dao;

import domain.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 从数据库中取出数据需有四个属性：数据库驱动，连接数据库的地址，数据库名称，数据库密码
 */
public class DaoImpl implements Dao {
    public List<Province> findAll() throws Exception {
        List<Province> list = new ArrayList<Province>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///practice","root","754683");
            //获取操作数据库的对象
            pst = connection.prepareCall("select * from province");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //将数据库结果集转成java的list集合
            while (rs.next()){
                Province province =new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                list.add(province);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
