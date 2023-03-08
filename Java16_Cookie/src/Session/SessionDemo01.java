package Session; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/12/3 09:18
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo01", value = "/SessionDemo01")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取session对象
        HttpSession session = request.getSession();
        //2. 在session中存储数据
        session.setAttribute("msg","WhatFuck");
    }
}
