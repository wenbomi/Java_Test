package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 小米
 * @date 2022/10/18
 * 插入一条语句
 */
public class jdbc_demo02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 定义sql
            String sql = "insert into account values(null,'小米',30000)";
            //3. 获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            // 4. 获取执行sql的对象 Statement
            stmt = connection.createStatement();
            //5. 执行sql
            int count = stmt.executeUpdate(sql); // 影响的行数
            //6. 处理结果
            if (count > 0){
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败！");
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            //7. 释放资源
            // 为了避免空指针异常
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
