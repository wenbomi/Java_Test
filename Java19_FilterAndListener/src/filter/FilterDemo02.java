package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/3 15:55
 * 简介： 在WEB.xml中配置过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "FilterDemo02")
public class FilterDemo02 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
