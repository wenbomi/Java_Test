package Response; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/25 13:52
 * 简介： 获取虚拟目录
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseDemo03", value = "/responseDemo03")
public class  ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo03....");
        // 动态获取虚拟目录
        String contextPath = request.getContextPath();

        //重定向
        response.sendRedirect(contextPath + "/responseDemo02");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
