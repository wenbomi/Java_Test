package Listener; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2023/1/7 16:30
 * 简介：
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

@WebListener
public class ContextLoaderListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public ContextLoaderListener() {
    }

    /**
     * 监听ServletContext对象创建的，ServletContext对象服务器启动后，自动创建。
     * 在服务器启动后自动调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */

        try {
            // 加载资源文件
            // 1。获取ServletContext对象
            ServletContext servletContext = sce.getServletContext();

            //2. 加载资源文件
            String contextConfigLocation = servletContext.getInitParameter("ContextConfigLocation");
            //3. 获取真实路径
            String realPath = servletContext.getRealPath(contextConfigLocation);
            //4. 加载进内存
            FileInputStream fis = new FileInputStream(realPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ServletContext对象被创建了...");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁，当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("ServletContext对象被销毁了...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
