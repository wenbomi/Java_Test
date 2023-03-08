package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小米
 * @date 2022/10/22
 * druid 工具类的展示
 */
public class JDBCUtils02 {
    //1. 定义成员变量
    private static DataSource ds;

    static {
        try {
            //2. 加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils02.class.getClassLoader().getResourceAsStream("druid.properties"));
            //3. 获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }

    /**
     * 释放资源01
     */
    public static  void close(Statement statement , Connection conn){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * 释放资源02
     */
    public static  void close(ResultSet rs, Statement statement , Connection conn){
        close(null,statement,conn);
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
