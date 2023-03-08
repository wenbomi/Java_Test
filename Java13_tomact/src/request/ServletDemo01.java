package request;
/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/22 10:12
 * 简介：演示Request对象来获取请求行数据
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求方式 ：GET
        String method = request.getMethod();
        System.out.println(method);

        // 2. (*)获取虚拟目录：/day13
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //3.  获取Servlet路径: /ServletDemo01
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4. 获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString); // null

        //5.(*)获取请求URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); // /day13/ServletDemo01
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL); // http://localhost:8080/day13/ServletDemo01

        //6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol); //HTTP/1.1

        //7.获取客户机的IP地址：
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr); // 0:0:0:0:0:0:0:1 这是IPV6的地址 而且是自己访问自己 若是别人访问我 显示的是IPv4的地址

        String host = request.getHeader("Accept-Language");
        System.out.println(host);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
