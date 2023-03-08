package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName requestDemo05
 * @Author Xiao Mi
 * @Date 2022/11/23 08:58
 * 简介：获取请求消息的其他功能
 */
@WebServlet("/requestDemo06")
public class requestDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post 获取请求参数
        // 1. String getParameter(String name):根据参数名称获取参数值
        System.out.println("-----------POST--------------");
        String value = req.getParameter("username");
//        System.out.println(value);

        // 2. String[] getParameterValues(String name):根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
//            System.out.println(hobby);
        }

        // 3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
//            System.out.println(name);
            String name_value = req.getParameter(name);
//            System.out.println(name + ":" + name_value); // 比如有多个爱好 但是这里只能获取一 解决方式为MAP集合的方式 如下
//            System.out.println("----------------");

        //4. Map<String,String[]> getParameterMap():获取所有参数的map集合
            // 获取所有的键值对
            Map<String, String[]> parameterMap = req.getParameterMap();
            // 获取键的集合
            Set<String> keySet = parameterMap.keySet();
            for (String key : keySet) {
                String[] key_value = parameterMap.get(key);
                for (String s : key_value) {
                    System.out.println(key + ":" + s);
                }
                System.out.println("---------------");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get获取请求参数
        // 1. String getParameter(String name):根据参数名称获取参数值
//        System.out.println("-----------GET--------------");
//        String value = req.getParameter("username");
//        System.out.println(value);
        this.doPost(req, resp);
    }
}
