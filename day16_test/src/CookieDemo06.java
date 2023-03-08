/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/2 10:00
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo06", value = "/CookieDemo06")
public class CookieDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3. 获取cookie
        System.out.println("test.....");
        Cookie[] cookies = request.getCookies();
        // 4. 获取数据，遍历cookies
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
            }
        }
    }
}
