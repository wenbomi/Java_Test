package Response; /**
 * @ClassName ${NAME}
 * @Author Xiao Mi
 * @Date 2022/11/26 15:22
 * 简介：验证码 案例
 */

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ResponseDemo06", value = "/responseDemo06")
public class ResponseDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置验证码图片的尺寸
        int width = 200;
        int height = 50;
        // 1. 创建对象，在内存中存放图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 2. 图片设计
        //2.1 设置画笔
        Graphics pen = image.getGraphics();
        pen.setColor(Color.PINK); // 设置画笔颜色
        pen.fillRect(0, 0, width, height); // 填充颜色

        // 2.2 画边框
        pen.setColor(Color.BLUE);
        pen.drawRect(0, 0, width - 1, height - 1);

        // 2.3 填写验证码
        String str = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            // 创建随机角标
            int index = random.nextInt(str.length());
            // 获取字符
            char ch = str.charAt(index);
            // 写验证码
            pen.drawString(ch + "", width / 5 * i, height / 2);
        }
        // 2.4 画干扰线
        pen.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            pen.drawLine(x1,y1,x2,y2);
        }

        // 3. 输出图片
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
