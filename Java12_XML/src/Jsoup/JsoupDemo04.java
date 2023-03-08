package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author 小米
 * @date 2022/11/17
 * 获取Element对象
 */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
        //1.获取xml文件路径
        String path = JsoupDemo04.class.getClassLoader().getResource("xml_demo/student.xml").getPath();
        //2.获取文件对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 通过Document对象获取name标签，获取的是全部的name标签
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size()); // 2
        System.out.println("------------");

        // 使用element对象获取子标签对象
        Element student1 = document.getElementsByTag("student").get(0); // 第一个student标签的元素对象
        System.out.println(student1);
        System.out.println("------------");
        Elements name1 = student1.getElementsByTag("name"); // 第一个student标签的元素对象的name标签对象
        System.out.println(name1);

        // 获取student对象的属性值
        System.out.println("------------");
        String attr = student1.attr("number");
        System.out.println(attr); //dangsheng_0001

        // 获取文本内容
        System.out.println("------------");
        String text = name1.text();
        String html = name1.html();
        System.out.println(text); // 直接获取子标签下所有标签的纯文本内容
        System.out.println(html); // 获取的是子标签下所有的内容，包括标签和文本内容
    }
}
