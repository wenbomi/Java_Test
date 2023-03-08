package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小米
 * @date 2022/10/20
 * 采用JDBC里的事务管理来进行转账操作
 */
public class jdbc_demo11 {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            // 1. 获取连接对象
            connection = JDBCUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            //2. 定义sql对象
            String sql1 = "update account set money = money - ? where id = ?";
            String sql2 = "update account set money = money + ? where id = ?";
            //3. 获取执行sql的对象
            ps1 = connection.prepareStatement(sql1);
            ps2 = connection.prepareStatement(sql2);
            //给？赋值
            ps1.setDouble(1,500);
            ps1.setInt(2,1);

            ps2.setDouble(1,500);
            ps2.setInt(2,2);

            //4.执行sql
            ps1.executeUpdate();
            // 手动增加异常
            //int i = 3/0;
            ps2.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            // 事务回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            // 5. 释放资源
            JDBCUtils.Close(ps1,connection);
            JDBCUtils.Close(ps2,connection);
        }

    }
}
