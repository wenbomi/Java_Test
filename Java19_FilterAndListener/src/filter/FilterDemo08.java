package filter;
/**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 16:19
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(value = "/*")
public class FilterDemo08 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("我是过滤器2执行了。。。");
        chain.doFilter(request, response);
        System.out.println("过滤器2回来了。。。");
    }
}
