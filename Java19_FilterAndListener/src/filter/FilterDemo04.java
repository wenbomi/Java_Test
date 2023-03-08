package filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 14:00
 * 简介： filter的生命周期
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo04 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象 然后调用init方法 加载资源
     * 只执行一次
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 服务器关闭后 filter对象被销毁 如果服务器正常关闭 则会执行destroy方法 释放资源
     * 只执行一次
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每次请求被拦截资源时 会执行
     * 可以执行多次
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter..."); // 执行过滤器
        chain.doFilter(request, response); // 执行放行后的资源 比如 本案例中的 index.jsp
        System.out.println("我被放行了。。。。");    // 执行放行代码下面的代码

    }
}
