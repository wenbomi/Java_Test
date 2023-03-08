package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 小米
 * @date 2022/10/19
 * 创建一张表
 */
public class jdbc_demo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1. 注册驱动 （可以省略）
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            //3. 定义sql语句
            String sql = "create table teacher(id int primary key auto_increment , name varchar(10))"; // 创建表
            //4. 获取制定sql的对象
            stmt = conn.createStatement();
            //5. 执行sql语句
            int count = stmt.executeUpdate(sql);
            //6. 处理结果
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // 7. 释放资源
            // 首先判断要释放的对象是否为空
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
