package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ClassName requestDemo05
 * @Author Xiao Mi
 * @Date 2022/11/23 08:58
 * 简介：获取请求消息体
 */
@WebServlet("/requestDemo05")
public class requestDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求消息体 --- 请求参数
        System.out.println("SAP");
        //1. 获取字符流
        BufferedReader br = req.getReader();
        //2. 读取数据
        String line = null;
        while ((line = br.readLine())!= null){
            System.out.println(line);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
