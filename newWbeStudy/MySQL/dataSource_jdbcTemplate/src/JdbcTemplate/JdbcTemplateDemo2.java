package JdbcTemplate;

import domain.Book;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //Junit单元测试，让方法独立运行

    //1.获取JDBCTemplate对象
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1. 修改1号数据的 price 为 100
     */
    @Test
    public void test1(){
        //2.定义SQL
        String sql = "update book set price=100 where id=1";
        //3.执行SQL
        int count = template.update(sql);
        System.out.println(count);
    }
    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into book(name,author,price) values(?,?,?)";
        int count = template.update(sql,"哈哈","哈哈哈",66);
        System.out.println(count);
    }
    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from book where id=?";
        int count = template.update(sql,15);
        System.out.println(count);
    }
    /**
     * 4.查询id为10的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        String sql = "select * from book where id=?";
        Map<String,Object> map = template.queryForMap(sql,10);
        System.out.println(map);
        //错误
        /*String sql = "select * from book where id=? or id=?";
        Map<String,Object> map = template.queryForMap(sql,10,11);*/
    }
    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5(){
        String sql = "select * from book";
        List<Map<String,Object>> list = template.queryForList(sql);
        for(Map<String,Object> stringObjectMap : list){
            System.out.println(stringObjectMap);
        }
    }
    /**
     * 6. 查询所有记录，将其封装为Book对象的List集合
     */
    @Test
    public void test6(){
        String sql = "select * from book";
        List<Book> list = template.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                int category_id = resultSet.getInt("category_id");

                book.setId(id);
                book.setName(name);
                book.setAuthor(author);
                book.setPrice(price);
                book.setCategory_id(category_id);

                return book;
            }
        });
        for(Book book : list){
            System.out.println(book);
        }
    }
    @Test
    public void test6_1(){
        String sql = "select * from book";
        List<Book> list = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        for(Book book : list){
            System.out.println(book);
        }
    }
    /**
     * 7. 查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select coind(id) from book";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
