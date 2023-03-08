package JDBC连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 小米
 * @date 2022/10/21
 * 使用c3p0创建连接
 */
public class C3P0Dmoe01 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接对象
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
}
