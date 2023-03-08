package servlet; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/2/22 10:54
 * 简介：
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名
        String username = request.getParameter("username");
//        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8"); //设置编码，是在获取流之前设置 （返回数据格式类型和编码）
        HashMap<String, Object> hashMap = new HashMap<>();
        // 调用service层 判断用户是否存在
        if ("xiaomi".equals(username)) {
            // 存在
            hashMap.put("userExsit", true);
            hashMap.put("msg", "此用户名太受欢迎，请更换！");
        } else {
            // 不存在
            hashMap.put("userExsit", false);
            hashMap.put("msg", "可使用！");
        }
        // 将map转为json 并传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), hashMap); // 将map转为json
    }
}
