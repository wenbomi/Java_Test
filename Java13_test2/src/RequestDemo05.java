import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RequestDemo05
 * @Author Xiao Mi
 * @Date 2022/11/25 09:12
 * 简介：请求转发：一种在服务器内部的资源跳转方式
 */
@WebServlet("/rdemo05")
public class RequestDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是火星.....");
        // 储存数据
        req.setAttribute("meg","Hello");
        //1. 通过request对象获取请求转发器对象
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/rdemo06");

        //2. 使用RequestDispatcher对象来进行转发
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
