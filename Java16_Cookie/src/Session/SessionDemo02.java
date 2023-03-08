package Session; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/3 09:20
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo02", value = "/SessionDemo02")
public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取session
        HttpSession session = request.getSession();

        // 获取数据
        Object value = session.getAttribute("msg");
        System.out.println(value);
    }
}
