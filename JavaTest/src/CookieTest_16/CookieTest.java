package CookieTest_16;
/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/2 09:25
 * 简介：cookie中中文的存储问题
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieDemo", value = "/CookieTest_16")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        // 设置指示符
        boolean flag = false;

        // 判断cookie数组是否为空
        if (cookies != null && cookies.length > 0) {
            // 遍历cookies寻找行名为loginTime
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("loginTime".equals(name)) {
                    // 说明不是第一次登陆
                    flag = true;
                    // 设置cookie的value值
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String time = dateFormat.format(date);
                    time = URLEncoder.encode(time, "utf-8");
                    cookie.setValue(time);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60 * 60);

                    // 响应数据，获取数据
                    String value = cookie.getValue();
                    time = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎你再次登陆，您上次的登陆时间为：" + time);
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            // 第一次登陆
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String time = dateFormat.format(date);
            time = URLEncoder.encode(time, "utf-8");
            Cookie cookie = new Cookie("loginTime", time);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            time = URLDecoder.decode(time, "utf-8");
            response.getWriter().write("欢迎首次登陆！");

        }

    }
}
