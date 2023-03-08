package request; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/22 10:57
 * 简介：获取请求头 user-agent 的信息
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletDemo02", value = "/requestDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取请求头数据 user-agent
        String agent = request.getHeader("user-agent");
        //判断浏览器的种类
        if (agent.contains("Chrome")){
            System.out.println("这是谷歌浏览器。。。");
        }else {
            System.out.println("这是其他的浏览器！");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
