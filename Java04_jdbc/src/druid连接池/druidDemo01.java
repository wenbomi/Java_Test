package druid连接池;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 小米
 * @date 2022/10/22
 * druid连接池演示
 */
public class druidDemo01 {
    public static void main(String[] args) throws Exception {
        //1. 倒入jar包
        //2. 定义配置文件
        //3. 加载配置文件
        Properties pro = new Properties(); // 加载器
        InputStream is = druidDemo01.class.getClassLoader().getResourceAsStream("druid.properties"); // 配置文件输入流
        pro.load(is);
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //5. 获取连接对象
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

    }
}
