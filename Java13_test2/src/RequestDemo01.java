import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RequestDemo01
 * @Author Xiao Mi
 * @Date 2022/11/24 16:10
 * 简介：获取请求消息数据
 */
@WebServlet("/rdemo01")
public class RequestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式 ：GET/Post String getMethod()
        String method = req.getMethod();
        System.out.println(method);  // POST

        //2. 获取虚拟目录 /test
        String contextPath = req.getContextPath();
        System.out.println(contextPath);  // /test2

        //3.获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath); // /rdemo01

        //4. 获取get方式请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString); // null

        //5. 获取请求URI
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI); // /test2/rdemo01
        System.out.println(requestURL);//  http://localhost:8080/test2/rdemo01

        //6.获取协议及版本：HTTP/1.1
        String protocol = req.getProtocol();
        System.out.println(protocol); // HTTP/1.1

        //7.获取客户机的IP地址
        String ip = req.getRemoteAddr();
        System.out.println(ip); // 0:0:0:0:0:0:0:1

    }
}
