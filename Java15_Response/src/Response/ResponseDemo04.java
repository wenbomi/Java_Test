package Response; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/26 14:23
 * 简介： 获取字符输出流 并指定浏览器解析的编码
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseDemo04", value = "/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取流对象之前，设置流的默认编码： 将ISO-8859-1 设置成 GBK
//        response.setCharacterEncoding("UTF-8");   这行可以省略
        //告诉浏览器 服务器发送的消息体数据的编码 建议浏览器使用该编码解码（即告诉浏览器当前编码设置成当前编码）
        //response.setHeader("content-type","text/html;charset = GBK");  // 包含了上述设置编码

        // 更为简单的方式设置编码
        response.setContentType("text/html;charset = UTF-8");
        // 1. 获取字符输出流
        PrintWriter pw = response.getWriter();

        // 2. 输出数据
        pw.write("Fuck the SAP  \n ");

        pw.write("你好 SAP");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
