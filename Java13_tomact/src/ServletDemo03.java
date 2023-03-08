import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Servlet.ServletDemo03
 * @Author Xiao Mi
 * @Date 2022/11/22 09:53
 * 简介：HttpServlet 中的doGet方法
 */

@WebServlet("*.do")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo03...");
        System.out.println(req);
    }
}
