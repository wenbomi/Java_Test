package project.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Author Xiao Mi
 * @Date 2022/11/23 14:07
 * 第二步
 * 简介：JDBC 工具类 使用Druid连接池
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        try {
            // 1.加载配置文件
            Properties pro = new Properties();
            // 使用ClassLoader来加载配置文件，获取字节输入流
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);

            // 2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
