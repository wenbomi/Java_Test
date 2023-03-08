import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date ${DATE} ${TIME}
 * 简介：
 */
public class Main implements Servlet {
    /**
     * 被创建：执行init方法，只执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务：执行service方法，执行多次
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("wocao");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 被销毁：执行destroy方法，只执行一次
     */
    @Override
    public void destroy() {

    }
}