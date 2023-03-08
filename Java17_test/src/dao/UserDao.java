package dao;

import domain.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Author Xiao Mi
 * @Date 2022/12/8 11:13
 * 简介： 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
}
