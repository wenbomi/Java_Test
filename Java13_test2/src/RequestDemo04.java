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
 * @ClassName RequestDemo01
 * @Author Xiao Mi
 * @Date 2022/11/24 16:10
 * 简介：获取请求参数通用方式
 * 不论get还是post请求方式都可以使用下列方法来获取请求参数
 */
@WebServlet("/rdemo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文乱码问题
        req.setCharacterEncoding("utf-8");
        //1. 根据参数名称获取参数值
        String username= req.getParameter("username");
        System.out.println("账号：" + username);
        String password= req.getParameter("password");
        System.out.println("密码：" + password);


        //2. 根据参数名称获取参数值的数组 主要是针对于checkbox类型的数据
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //3. 获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);
            System.out.println(name + ":" + value);
        }

        //4. 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            String[] key_value = parameterMap.get(key);
            for (String s : key_value) {
                System.out.println(key + ":" + key_value);
            }
        }

    }
}
