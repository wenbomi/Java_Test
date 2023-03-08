package jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName JedisPoolUtils
 * @Author Xiao Mi
 * @Date 2023/3/4 17:00
 * 简介： JedisPool工具类 加载配置文件 配置连接池参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 获取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 创建一个properties对象
        Properties properties = new Properties();
        // 关联文件

        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 获取数据 设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal"))); // 数据类型转换 字符串转int
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle"))); // 数据类型转换 字符串转int
        // 初始化
        jedisPool = new JedisPool(config, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    /*
        获取连接方法
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
