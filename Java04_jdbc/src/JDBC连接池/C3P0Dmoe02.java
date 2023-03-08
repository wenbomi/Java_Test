package JDBC连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 小米
 * @date 2022/10/21
 * c3p0演示2
 */
public class C3P0Dmoe02 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接对象,无参的条件下默认使用默认配置
        DataSource ds = new ComboPooledDataSource();
        // 1.1 使用其他配置文件
        //DataSource ds1 = new ComboPooledDataSource("otherc3p0");
        // 2. 验证最大连接对象是否为10个
        for (int i = 1; i <= 11 ; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + "-- " + connection);
            if (i == 5){
                // 归还连接池 而不是关闭
                connection.close();
            }
        }
    }
}
