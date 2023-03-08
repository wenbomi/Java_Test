package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/3 16:16
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo03 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("demo3被执行...");
        
        // 放行
        chain.doFilter(request, response);

        // 对response对象的响应消息增强
        System.out.println("demo3回来了...");
    }
}
