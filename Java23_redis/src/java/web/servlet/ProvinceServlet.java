package web.servlet;
/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/3/5 20:48
 * 简介：
 */


import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 1 调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println("CCCCCCCC");
        // 2 序列化list为json

        System.out.println(json);

        //3 响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
