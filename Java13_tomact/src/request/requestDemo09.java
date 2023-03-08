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
 * 简介：
 */
@WebServlet("/requestDemo09")
public class requestDemo09 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo09被转发中。。。。。。。。。");
        // 获取共享空间的数据
        Object mes = req.getAttribute("mes");
        System.out.println(mes);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    doPost(req,resp);
    }
}
