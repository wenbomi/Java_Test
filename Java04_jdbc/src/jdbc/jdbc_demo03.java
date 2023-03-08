package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 小米
 * @date 2022/10/18
 * 更新一条语句
 */
public class jdbc_demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1. 注册驱动 （可以省略）
//            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            //3. 定义sql语句
            String sql = "update account set money = 5000 where id = 2";
            //4. 获取制定sql的对象
            stmt = conn.createStatement();
            //5. 执行sql语句
            int count = stmt.executeUpdate(sql);
            //6. 处理结果
            System.out.println(count);
            if (count > 0){
                System.out.println("数据更新成功！");
            }else{
                System.out.println("更新失败！");
            }
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
