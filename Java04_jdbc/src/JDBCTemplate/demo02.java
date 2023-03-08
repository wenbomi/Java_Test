package JDBCTemplate;

import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JDBCUtils02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author 小米
 * @date 2022/10/22
 */
public class demo02 {
    //1. 获取JdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils02.getDataSource());
    // Junit 单元测试

    /**
     * 修改1号数据的 salary 为 10000
     */
    @Test
    public void test01() {
        //2. 定义sql语句
        String sql = "update emp set salary = 10000 where id =  ?";
        //3.执行sql
        int count = template.update(sql, 1001);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test02() {
        String sql = "insert into emp(id,ename,dept_id) values (1015,'花泽类',10)";
        int count = template.update(sql);
    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test03() {
        String sql = "delete from emp where id = ?";
        template.update(sql, 1015);
    }

    /**
     * 4. 查询id为1的记录，将其封装为Map集合
     */
    @Test
    public void test04() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test05() {
        String sql = "select * from emp";
        List<Map<String, Object>> mapList = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test06() {
        String sql = "select * from emp";
        List<Emp> emps = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {

                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                Double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                Emp emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);

                return emp;
            }
        });
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合 (改进版)
     */
    @Test
    public void test07() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test08() {
        String sql = "select count(id) from emp";
        Long object = template.queryForObject(sql, Long.class);
        System.out.println(object);
    }


}
