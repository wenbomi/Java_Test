package cookie; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/2 09:25
 * 简介：cookie中中文的存储问题
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CookieDemo04", value = "/CookieDemo04")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "哈哈哈哈哈哈哈哈");

        // 设置path，
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
