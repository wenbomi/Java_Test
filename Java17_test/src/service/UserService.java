package service;

import domain.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Author Xiao Mi
 * @Date 2022/12/8 11:10
 * 简介： 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
}
