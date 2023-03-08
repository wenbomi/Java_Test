package druid连接池;

import util.JDBCUtils02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小米
 * @date 2022/10/22
 * 使用Durid工具类的方式
 */
public class druidDemo02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接对象
            connection = JDBCUtils02.getConnection();
            //2. 定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取执行sql的对象
            ps = connection.prepareStatement(sql);
            //4. 为sql语句赋值
            ps.setString(1, "xiaowang");
            ps.setDouble(2, 6000);
            //5. 执行sql
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 释放资源
            JDBCUtils02.close(ps,connection);
        }
    }
}

