import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletDemo04
 * @Author Xiao Mi
 * @Date 2022/11/24 15:39
 * 简介：HttpServlet：对http协议的一种封装，简化操作 抽象类
 *      1. 定义类继承HttpServlet
 *      2. 复写doGet/doPost方法
 */
@WebServlet("/demo4")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("简介：HttpServlet：对http协议的一种封装，简化操作 抽象类");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

    }
}
