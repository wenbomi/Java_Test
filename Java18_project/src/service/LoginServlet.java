package service;

import dao.impl.UserDaoImpl;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置request编码
        request.setCharacterEncoding("utf-8");
        //2. 获取参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        String checkCode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();

        // 3. 获取Session对象中的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        if (!checkCode_session.equalsIgnoreCase(checkCode)){
            // 验证码不正确
            // 显示提示信息
            request.setAttribute("login_msg","验证码错误！");
            // 跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        // 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 调用Service查询
        UserService service = new UserServiceImpl();
        service.


//        // 删除验证码
//        session.removeAttribute("checkCode_session");
//        // 3.1 判断验证码是否正确
//        if (checkCode_session != null &&checkCode_session.equalsIgnoreCase(checkCode)){
//            // 忽略大消息字符串
//            // 验证码正确
//            // 判断用户名和密码是否正确
//            if ("xiaomi".equals(username) && "123".equals(password)){ // 正常来说这里应该是查询数据库的
//                // 登陆成功
//                // 存储用户信息
//                session.setAttribute("user",username);
//                // 重定向到success.jsp
////                response.sendRedirect(request.getContextPath() + "/success.jsp");
//                response.sendRedirect("https://cn.pornhub.com/");
//            }else {
//                // 登陆失败
//                // 存储信息到request
//                request.setAttribute("login_error","用户名或密码不正确");
//                // 转发到登陆页面
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
//
//            }
//        }else {
//            // 验证码验证失败
//            // 存储信息到request
//            request.setAttribute("cc_error","验证码登陆失败");
//            // 转发到登陆页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
