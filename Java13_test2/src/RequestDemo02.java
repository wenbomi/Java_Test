import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @ClassName RequestDemo01
 * @Author Xiao Mi
 * @Date 2022/11/24 16:10
 * 简介：获取请求头数据
 */
@WebServlet("/rdemo02")
public class RequestDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取确定名称的请求头数据
        String value = req.getHeader("Accept-Language");
        System.out.println(value); // zh-CN,zh-Hans;q=0.9

        // 2.获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }

        /**
                host
                accept
                accept-encoding
                accept-language
                content-type
                origin
                user-agent
                connection
                upgrade-insecure-requests
                referer
                content-length
                cookie
         */




    }
}
