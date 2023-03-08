package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName jdbc_test
 * @Author Xiao Mi
 * @Date 2022/12/8 22:29
 * 简介：
 */
public class jdbc_test {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql:///db1","root","minan0417");
            statement = connection.createStatement();
            String sql = "insert into account values(null,'jiangjiang',3000)";
            int acc = statement.executeUpdate(sql);
            System.out.println(acc);
            if (acc > 0){
                System.out.println("插入成功！");
            }else {
                System.out.println("插入失败！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
