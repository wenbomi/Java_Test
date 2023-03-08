import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;
import util.JDBCUtils;
import util.JedisPoolUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName test
 * @Author Xiao Mi
 * @Date 2023/3/7 11:15
 * 简介：
 */
public class test {
    @Test
    public void test1() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 1 定义sql
        String sql = "select * from province";
        // 2 执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        for (Province province : list) {
            System.out.println(province);
        }
    }

    @Test
    public void test2() throws JsonProcessingException {
        ProvinceDao dao = new ProvinceDaoImpl();

        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        System.out.println(province_json);
        List<Province> list = dao.findAll();
        System.out.println(list.size());
        ObjectMapper mapper = new ObjectMapper();
        province_json = mapper.writeValueAsString(list);
        jedis.set("province", province_json);
        System.out.println("导入成功！");
        //归还连接
        jedis.close();
    }

    @Test
    public void test3() {
        ProvinceService service = new ProvinceServiceImpl();
        String allJson = service.findAllJson();
        System.out.println(allJson);
    }

    @Test
    public void test4() {
        Jedis jedis = JedisPoolUtils.getJedis();
//        jedis.del("province");
        System.out.println(jedis.keys("*"));
        jedis.close();

    }

}
