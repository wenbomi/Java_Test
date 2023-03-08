package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/3 15:42
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*") // 访问所有资源之前，都会执行该过滤器
public class FilterDemo01 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("demo01被执行了...");

        // 放行
        chain.doFilter(request,response);
    }
}
