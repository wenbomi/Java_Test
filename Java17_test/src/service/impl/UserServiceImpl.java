package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author Xiao Mi
 * @Date 2022/12/8 11:12
 * 简介：
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 1. 调用dao完成查询
        return dao.findAll();
    }
}
