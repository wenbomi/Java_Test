import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName RequestDemo01
 * @Author Xiao Mi
 * @Date 2022/11/24 16:10
 * 简介：获取请求体数据
 * 只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
 */
@WebServlet("/rdemo03")
public class RequestDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取流对象
        BufferedReader reader = req.getReader();
        System.out.println(reader);

    }
}
