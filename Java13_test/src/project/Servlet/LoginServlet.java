package project.Servlet;



import org.apache.commons.beanutils.BeanUtils;
import project.dao.Userdao;
import project.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ClassName LoginServlet
 * @Author Xiao Mi
 * @Date 2022/11/23 15:23
 * 简介：第四步
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
//        //2. 获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        //3. 封装User对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //2.获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 创建User对象
        User loginUser = new User();
        //3.1 使用BeanUtils封装对象信息
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //4. 调用UserDao的login方法
        Userdao dao = new Userdao();
        User user = dao.login(loginUser);

        //5. 判断User
        if (user == null){
            // 没有查询到
            // 转发
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            // 登陆成功
            // 存储数据
            req.setAttribute("user",user);
            // 转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }
}
