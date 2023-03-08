package request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * 简介： 请求转发
 */
@WebServlet("/requestDemo08")
public class requestDemo08 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo08显示中。。。。。。。。");
        // 将数据存入到共享空间
        req.setAttribute("mes","你好");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo09");
        requestDispatcher.forward(req,resp);

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    doPost(req,resp);
    }
}
