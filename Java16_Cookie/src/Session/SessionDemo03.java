package Session; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/3 09:43
 * 简介： session 存活时间探究以及 完成长时间的存活
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo03", value = "/SessionDemo03")
public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);  // 关闭浏览器后 重新访问结果是不同的
        System.out.println(session.getId());  // 获取的是JSESSIONID的值
        // 期望关闭浏览器后，session也可以相同
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie); // 这样不管浏览器是否关闭cookie都是保持相同 在一个小时内
    }
}
