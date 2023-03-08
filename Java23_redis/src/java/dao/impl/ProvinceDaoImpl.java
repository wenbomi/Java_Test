package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @ClassName ProvinceDaoImpl
 * @Author Xiao Mi
 * @Date 2023/3/4 20:36
 * 简介： 查找mysql数据库信息
 */
public class ProvinceDaoImpl implements ProvinceDao {
    // 声明成员变量 jdbctemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        // 1 定义sql
        String sql = "select * from province";
        // 2 执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return list;

    }
}
