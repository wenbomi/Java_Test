package project.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import project.domain.User;
import project.util.JDBCUtils;

/**
 * @ClassName Userdao
 * @Author Xiao Mi
 * @Date 2022/11/23 14:04
 * 第三步
 * 简介：操作数据库中User表的类
 */
public class Userdao {

    // 声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登陆方法
     * @param loginUser 输入的是用户输入的账号 和 密码
     * @return 返回的是用户全部数据,没有查询到 返回一个null值
     */
    public User login(User loginUser){
        try {
            // 1. 编写sql
            String sql = "select * from user where username = ? and password = ? ";
            //2. 调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());

            return user;

        } catch (DataAccessException e) {
            return null;
        }
    }
}
