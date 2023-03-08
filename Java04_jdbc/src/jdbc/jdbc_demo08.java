package jdbc;

import domain.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小米
 * @date 2022/10/19
 * 定义一个方法，查询emp表中的数据将其封装成对象，然后装载集合，返回
 * 使用工具类的查询方式，演示JDBC工具类
 */
public class jdbc_demo08 {
    public static void main(String[] args) {
        List<Emp> list = new jdbc_demo08().findAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
//            //1. 注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2. 获取连接对象
//            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
            conn = JDBCUtils.getConnection();
            //3. 定义SQL语句
            String sql = "select * from emp";
            //4. 获取执行SQL对象
            statement = conn.createStatement();
            //5. 执行SQL
            rs = statement.executeQuery(sql);
            //6. 遍历结果
            Emp emp = null;
            list = new ArrayList<>();
            while (rs.next()) {
                // 获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象,并赋值
                emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                // 装载对象
                list.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 7.释放资源
           JDBCUtils.Close(rs,statement,conn);
        }
        return list;
    }
}
