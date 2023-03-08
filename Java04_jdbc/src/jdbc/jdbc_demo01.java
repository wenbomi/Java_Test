package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 小米
 * @date 2022/10/18
 * jdbc 入门
 */
public class jdbc_demo01 {
    public static void main(String[] args)  throws  Exception{
        // 1. 倒入驱动jar包
        // 2. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //3. 获取数据库的连接对象,connectiond对象
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","minan0417");
        //4. 定义sql语句
        String sql = "update account set money = 3000 where id = 100";
        //5. 获取执行sql的对象 Statement
        Statement stmt = connection.createStatement();
        //6. 执行sql
//        int count = stmt.executeUpdate(sql);
        boolean bl = stmt.execute(sql);// 即使数据库表修改成功，返回 的也是false.
        //7. 处理结果
//        System.out.println(count);
        System.out.println(bl);
        //8. 释放资源
        stmt.close(); //先是执行对象释放，然后是连接对象释放
        connection.close();


    }
}
