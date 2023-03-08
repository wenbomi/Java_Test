package download; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/29 20:19
 * 简介：
 */

import utils.DownLoadUtils;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "Servletdemo01", value = "/Servletdemo01")
public class Servletdemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数，也就是文件名称
        String filename = request.getParameter("filename");
        // 使用字节输入流加载文件进内存
        //2.1 获取文件的真实服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3. 设置response的响应头
        //3.1 设置响应头类型 content-type
        String mimeType = context.getMimeType(filename); // 获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2 设置响应头的打开方式 content-dispositon
        // 解决中文文件名问题
        // 1. 获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2. 使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filename=" + filename);
        //4. 将输入流的数据写出到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read()) != -1){
            outputStream.write(bytes,0,len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
