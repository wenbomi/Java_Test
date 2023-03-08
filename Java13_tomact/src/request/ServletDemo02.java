package request; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/22 10:57
 * 简介：request获取请求头
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet( value = "/requestDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取请求头数据
        // 获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        // 遍历
        while (headerNames.hasMoreElements()){
            String name= headerNames.nextElement();
            // 根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
