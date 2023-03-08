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
 * 简介：请求转发2：一种在服务器内部的资源跳转方式
 */
@WebServlet("/rdemo06")
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这里是火星中转站....");
        // 获取共享数据
        Object meg = req.getAttribute("meg");
        System.out.println("共享数据为：" + meg);

        req.getRequestDispatcher("/rdemo07").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
