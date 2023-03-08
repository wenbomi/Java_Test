package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 14:37
 * 简介：过滤器配置详解
 *      拦截路径配置
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/index.jsp")     //1.具体资源路径 / index.jsp 只有访问
//@WebFilter("/user/*")       // 2. 拦截目录 /user/*访问 / user下的所有资源时 过滤器被执行
//@WebFilter("*.jsp")          // 3. 后缀名拦截 只有访问后缀名为jsp资源时 过滤器会执行
public class FilterDemo05 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo05....");
        chain.doFilter(request, response);
    }
}
