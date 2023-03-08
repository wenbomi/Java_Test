package jedis.test;

import jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName JedisTest
 * @Author Xiao Mi
 * @Date 2023/3/3 14:55
 * 简介： Jedis的测试类
 */
public class JedisTest {
    /**
     * Jedis快速入门
     */
    @Test
    public void test1() {
        //1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2 操作
        jedis.set("username", "HHHHA");
        //3 关闭连接
        jedis.close();
    }

    /**
     * string类型的操作
     */
    @Test
    public void test2() {
        //1 获取连接
        Jedis jedis = new Jedis(); // 可以空参 默认值 "localhost", 6379
        //2 操作
        // 存储
        jedis.set("username", "AAAAA");
        // 获取
        String name = jedis.get("username");
        System.out.println(name); // AAAA

        // 使用setex() 方法储存可以指定过期时间的 key value
        // 设置键activecode 值为 HAHA 20秒后删除掉
        jedis.setex("activecode", 10, "HAHA");
        //3 关闭连接
        jedis.close();
    }

    /**
     * Hash类型的操作
     */
    @Test
    public void test3() {
        //1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2 操作
        // 存储
        jedis.hset("myhash", "age", "23");
        jedis.hset("myhash", "sex", "M");
        jedis.hset("myhash", "addr", "China");

        // 获取
//        String name = jedis.hget("myhash", "username");
//        System.out.println(name);
        Map<String, String> myhash = jedis.hgetAll("myhash");
        // 获取所有的键
        Set<String> keySet = myhash.keySet();
        for (String s : keySet) {
            String value = jedis.hget("myhash", s);
            System.out.println(s + " : " + value);
        }
        //3 关闭连接
        jedis.close();
    }

    /**
     * List类型使用
     */
    @Test
    public void test4() {
        //1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2 操作
        jedis.del("mylist");
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");
        //获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        // list pop
        String elemet1 = jedis.lpop("mylist");
        String elemet2 = jedis.rpop("mylist");
        System.out.println(elemet1);
        System.out.println(elemet2);
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        //3 关闭连接
        jedis.close();
    }

    /**
     * Set 类型使用
     */
    @Test
    public void test5() {
        //1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2 操作 set
        jedis.del("myset");
        jedis.sadd("myset","java","C++","Python");
        //获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.del("myst");
        System.out.println(jedis.keys("*"));
        //3 关闭连接
        jedis.close();
    }

    /**
     * sortedSet 类型使用
     */
    @Test
    public void test6() {
        //1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2 操作 set
        jedis.del("mysort");
        jedis.zadd("mysort",3,"AAA");
        jedis.zadd("mysort",30,"BBB");
        jedis.zadd("mysort",1,"CCC");
        // 获取
        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        System.out.println(mysort);
        //3 关闭连接
        jedis.close();
    }

    /**
     * jedis 连接池对象 使用
     */
    @Test
    public void test7() {
        //1 创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //2 创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //3 获取连接
        Jedis jedis = jedisPool.getResource();

        //4 处理数据
        jedis.set("HAHA","AAA");
        System.out.println(jedis.get("HAHA"));

        //5 关闭 归还到连接池
        jedis.close();
    }

    /**
     * jedis 连接池工具类的 使用
     */
    @Test
    public void test8() {
        Jedis jedis = JedisPoolUtils.getJedis();

        //4 处理数据
        jedis.set("HAHA","AAA");
        System.out.println(jedis.get("HAHA"));

        //5 关闭 归还到连接池
        jedis.close();
    }
}
