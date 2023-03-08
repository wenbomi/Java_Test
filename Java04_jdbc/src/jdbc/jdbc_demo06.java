package jdbc;

import java.sql.*;

/**
 * @author 小米
 * @date 2022/10/19
 * 查询表 并 读取表中值
 */
public class jdbc_demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //1. 注册驱动 （可以省略）
//            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            //3. 定义sql语句
            String sql = "select * from account"; // 创建表
            //4. 获取制定sql的对象
            stmt = conn.createStatement();
            //5. 执行sql语句
            resultSet = stmt.executeQuery(sql);
            //6. 处理结果
//            resultSet.next(); // 游标下移一位
            // 判断游标是否在最后一行之后
            while (resultSet.next()) {
                //6.1 获取数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double money = resultSet.getDouble("money");
                System.out.println(id+ "---"+ name + "---" + money);
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
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
