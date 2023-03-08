package jdbc;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author 小米
 * @date 2022/10/19
 * 需求：
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 */
public class jdbc_demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查询的用户名...");
        String username = sc.nextLine();
        System.out.println("请输入密码...");
        String password = sc.nextLine();
        if (new jdbc_demo10().login(username, password)) {
            System.out.println("查询成功，存在此账户！");
        } else {
            System.out.println("数据库中不存在此账户！");
        }

    }

    /**
     * 登陆方法，使用prepareStatement实现
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet1 = null;
        try {
            // 1.建立数据库的连接
            connection = JDBCUtils.getConnection();
            //2.定义sql语句
            String sql = "select * from user where username = ? and password = ?";
            //3.获取执行sql的对象
            ps = connection.prepareStatement(sql);
            // 给问号？赋值的操作
            ps.setString(1,username);
            ps.setString(2,password);
            //4.执行sql语句,不需要传入sql参数
            resultSet1 = ps.executeQuery();
            // 5.判断查询结果
            return resultSet1.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 释放资源
            JDBCUtils.Close(resultSet1,ps,connection);
        }
    }
}
