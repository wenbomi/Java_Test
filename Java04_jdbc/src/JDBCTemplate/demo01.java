package JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils02;

/**
 * @author 小米
 * @date 2022/10/22
 * Template入门
 */
public class demo01 {
    public static void main(String[] args) {
        //1. 倒入jar包
        //2. 创建JDBC Template对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils02.getDataSource());
        //3. 调用方法
        String sql = "update account set money = 1 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
