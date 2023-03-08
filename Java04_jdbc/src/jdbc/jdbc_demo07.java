package jdbc;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小米
 * @date 2022/10/19
 * 定义一个方法，查询emp表中的数据将其封装成对象，然后装载集合，返回
 */
public class jdbc_demo07 {
    public static void main(String[] args) {
        List<Emp> list = new jdbc_demo07().findAll();
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
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "minan0417");
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 7.释放资源
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
}
