package dao;

import domain.Province;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public List<Province> findAll() throws Exception;
}
