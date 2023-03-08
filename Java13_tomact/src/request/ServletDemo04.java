package request; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/22 10:57
 * 简介： 演示盗链原理
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value = "/requestDemo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取请求头数据 referer
        String referer = request.getHeader("referer");
        System.out.println(referer);  // http://localhost:8080/day13/login.html

        //2 防盗链
        if (referer != null ){
            if (referer.contains("/day13")){
                System.out.println("可以正常播放...");
            }else {
                System.out.println("您这是盗链行为，给你寄律师函！");
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
