package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
