package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用Redis缓冲
     * @return
     */
    @Override
    public String findAllJson() {
        //1.从Redis中查询数据
        //1.1获取Redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2.判断 province_json 是否为 null
        if(province_json == null || province_json.length() == 0){
            //redis中没有数据
            System.out.println("redis中没数据，查询数据库...");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入Redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("Redis中有数据，查询缓存...");
        }
        return province_json;
    }
}
