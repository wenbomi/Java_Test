import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo03
 * @Author Xiao Mi
 * @Date 2022/11/24 15:36
 * 简介：GenericServlet -- 抽象类
 *      GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
 */
@WebServlet("/demo3")
public class ServletDemo03  extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象");
    }
}
