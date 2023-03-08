package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 15:13
 * 简介：过滤器拦截方式配置
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 浏览器直接访问index.jsp资源时，过滤器会被执行
//@WebFilter(value = "/index.jsp" , dispatcherTypes = DispatcherType.REQUEST)
// 只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter(value = "/index.jsp" , dispatcherTypes = DispatcherType.FORWARD)
//浏览器直接访问index.jsp资源或者是转发访问index.jsp时，过滤器会被执行
//@WebFilter(value = "/*" , dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo06 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器被执行了。。。");
        chain.doFilter(request, response);
    }
}
