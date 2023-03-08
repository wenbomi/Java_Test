package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName requestDemo07
 * @Author Xiao Mi
 * @Date 2022/11/23 10:04
 * 简介： 解决post中乱码的问题
 */
@WebServlet("/requestDemo07")
public class requestDemo07 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据请求名获取请求值
        // 设置流的编码
        req.setCharacterEncoding("utf-8");
        String value = req.getParameter("username");
        System.out.println(value);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    doPost(req,resp);
    }
}
