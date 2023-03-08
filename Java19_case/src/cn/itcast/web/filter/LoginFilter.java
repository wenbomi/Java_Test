package cn.itcast.web.filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/5 17:17
 * 简介：登陆验证的过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        System.out.println(request);
        // 1. 为了使用获取请求路径的方法 需要强制转换
        HttpServletRequest req = (HttpServletRequest) request;
        //2. 获取资源请求路径
        String uri = req.getRequestURI();
//        System.out.println("HHHHHHH" + uri);

        //3. 判断是否包含登陆相关资源路径 注意要排除掉 css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")|| uri.contains("/css/")
                || uri.contains("/js/")|| uri.contains("/fonts/")|| uri.contains("/checkCodeServlet")){
            // 表示用户想登陆 允许访问登陆页面的资源
            //放行
            chain.doFilter(request,response);
        }else {
            // 表示用户不是想登陆 而是想去访问其他页面
            // 判断用户是否是登陆状态 从session中获取 user
            Object user = req.getSession().getAttribute("user");
            if (user != null){
                // 表示用户登陆过 放行
                chain.doFilter(request,response);
            }else {
                // 没有登陆 跳转页面
                req.setAttribute("login_msg","您尚未登陆，请先登陆...");
                req.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }

        //chain.doFilter(request, response);
    }
}
