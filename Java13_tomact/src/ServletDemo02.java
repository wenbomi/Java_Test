import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName Servlet.ServletDemo02
 * @Author Xiao Mi
 * @Date 2022/11/21 17:13
 * 简介：servlet路径设置
 */
//@WebServlet({"/demo3" ,"/demo22","/demo222"})
@WebServlet("/user/demo2")
//@WebServlet("*.do") // 自定义的拓展名 可以是任意的 比如 *.xiaomi *.haha都是可以的
public class ServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hhhhhhhahaha");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
