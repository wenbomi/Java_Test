package request;

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
 * 简介：获取ServletContext：
 */
@WebServlet("/requestDemo10")
public class requestDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext); // org.apache.catalina.core.ApplicationContextFacade@68c4269f
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    doPost(req,resp);
    }
}
