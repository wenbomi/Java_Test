package cookie; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/2 09:12
 * 简介：cookie的存储时间
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo03", value = "/CookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建cookie对象
        Cookie c1 = new Cookie("msg","SetMaxAge");
        //2. 设置cookie的存活时间
        c1.setMaxAge(-1); //浏览器关闭就设置的cookie就失效了
//        c1.setMaxAge(30); //浏览器关闭就设置的cookie在30秒后失效 ，将cookie持久化到硬盘
//        c1.setMaxAge(0); // 立即删除cookie
        //3. 发送cookie
        response.addCookie(c1);
    }
}
