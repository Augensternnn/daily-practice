package travel.service.imp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import travel.dao.CategoryDao;
import travel.dao.impl.CategoryDaoImpl;
import travel.domain.Category;
import travel.service.CategoryService;
import travel.util.JedisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.从Redis中查询
        //1.1获取Jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //1.2使用sortedset排序查询
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        //1.3查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        List<Category> cs = null;
        //2.判断查询的集合是否为空
        if(categorys == null || categorys.size() == 0){
            System.out.println("从数据库查询...");
            //3.如果为空，需要从数据库查询，再将数据存入Redis
            //3.1从数据库查询
            cs = categoryDao.findAll();
            //3.2将集合数据存储到Redis中的 category的key
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }
        }else {
            System.out.println("从Redis查询...");
            //4.如果不为空，将set是数据存入list[因为要返回list集合，categorys为set集合，故转换]
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
