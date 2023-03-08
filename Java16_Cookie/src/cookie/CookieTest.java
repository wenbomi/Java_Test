package cookie; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/2 10:27
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

@WebServlet(name = "CookieTest", value = "/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应体的数据格式和编码
        response.setContentType("text/html;charset=utf-8");
        // 获取所有cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false; // 没有名为lastTime的cookie头

        // 遍历cookies
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 获取cookie的头
                String name = cookie.getName();
                // 说明不是第一次登陆 设置响应数据
                if ("lastTime".equals(name)) {
                    flag = true;
                    //设置cookie的value值
                    // 获取当前时间的字符串，重新设置成cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_data = dateFormat.format(date);
                    System.out.println("编码前的时间："  + str_data);
                    // 对时间进行编码
                    str_data = URLEncoder.encode(str_data, "utf-8");
                    System.out.println("编码后的时间：" + str_data);
                    cookie.setValue(str_data);

                    // 设置cookie的存活时间
                    cookie.setMaxAge(10); // 一个月
                    response.addCookie(cookie);

                    // 响应数据 获取cookie时间
                    String value = cookie.getValue();
                    System.out.println("解码前的值：" + value);
                    // 对value进行解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后的值：" + value);
                    response.getWriter().write("<h1> 欢迎回来，您上次的访问时间为：" + value + "</h1>");
                    break;
                }
            }
        }
        // 当是第一次访问时
        if (cookies == null || cookies.length == 0 || flag == false) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String time = sdf.format(date);
            System.out.println("编码前的时间："  + time);
            // 对时间进行编码
            time= URLEncoder.encode(time, "utf-8");
            System.out.println("编码后的时间：" + time);

            Cookie cookie = new Cookie("lastTime", time);
            // 设置cookie的存活时间
            cookie.setMaxAge(30 * 24 * 60 * 60);
            response.addCookie(cookie);
            time = URLDecoder.decode(time);
            response.getWriter().write("欢迎首次登陆" + time);
        }
    }
}
