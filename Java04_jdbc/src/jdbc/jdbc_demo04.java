package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 小米
 * @date 2022/10/19
 * 删除一条数据
 */
public class jdbc_demo04 {
    public static void main(String[] args)  {
        // 为了防止出现在try中某个字段出现异常，导致连接或者执行对象为空
        Connection connection = null;
        Statement statement = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 定义sql语句
            String sql = "delete from account  where id  = 4";
            //3. 获取连接数据库对象
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            //4. 获取执行sql对象
            statement = connection.createStatement();
            //5. 执行SQL
            int count = statement.executeUpdate(sql);
            //6. 处理执行结果
            System.out.println(count);
            if (count > 0 ){
                System.out.println("执行成功！");
            }else{
                System.out.println("执行失败！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // 7.释放资源
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
