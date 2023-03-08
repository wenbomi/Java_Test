package web.servlet; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/8 11:09
 * 简介：
 */

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userListServlet", value = "/userListServlet")
public class userListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        //2. 将list存入request域
        request.setAttribute("users",users);

        //3. 转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }
}
