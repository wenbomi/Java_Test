package cn.itcast.web.filter; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/7 14:58
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


@WebFilter(value = "/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        try {
            //1. 获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            //2. 读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            //3. 把文件的每一行数据添加到list中去
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("敏感词汇有：" + list);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1. 创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强getParameter方法
                // 判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    // 增强返回值
                    // 获取返回值
                    String value = (String) method.invoke(request, args);
                    if (value != null){
                        for (String s : list) {
                            if (value.contains(s)){
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request,args);
            }
        });
        // 放行
        chain.doFilter(proxy_req, response);
        System.out.println("敏感词汇过滤完毕...");
    }
}
