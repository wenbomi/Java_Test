package Response; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/26 14:46
 * 简介： 获取字节输出流 并设置编码
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseDemo05", value = "/responseDemo05")
public class ResponseDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        response.setContentType("text/html;scharet = utf-8");

        // 1. 获取字节输出流
        ServletOutputStream sos = response.getOutputStream();

        // 2. 输出数据
        sos.write("你好 ABAP".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
