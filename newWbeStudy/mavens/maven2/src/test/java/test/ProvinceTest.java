package test;

import dao.Dao;
import dao.DaoImpl;
import domain.Province;
import org.junit.Test;

import java.util.List;

public class ProvinceTest {
    @Test
    public void findAll() throws Exception {
        Dao dao = new DaoImpl();
        List<Province> list = dao.findAll();
        for (Province province : list) {
            System.out.println(province.getName());
        }
    }
}
