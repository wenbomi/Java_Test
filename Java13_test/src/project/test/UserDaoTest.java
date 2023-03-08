package project.test;

import org.junit.Test;
import project.dao.Userdao;
import project.domain.User;

/**
 * @ClassName UserDaoTest
 * @Author Xiao Mi
 * @Date 2022/11/23 14:32
 * 简介： 测试
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("xiaomi");
        loginUser.setPassword("1234");

        Userdao dao = new Userdao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
