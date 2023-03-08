package Jsoup; /**
 * @author 小米
 * @date 2022/11/16
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup入门
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws Exception {
        //1. 倒入jar包
        //2.获取Document对象，根据xml文档获取
        //2.1 获取student.xml文件的路径
        String path = JsoupDemo01.class.getClassLoader().getResource("xml_demo/students.xml").getPath();
        //2.2 解析xml文档路径，加载文档到内存，获取dom树----> Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素 Elemet对象 获取name标签元素节点
        Elements elements_name = document.getElementsByTag("name");

        for (Element element : elements_name) {
            System.out.println(element);
            System.out.println("-----------");
        }

        // 3.1获取第一个name标签的Element对象
        Element element = elements_name.get(0);
        System.out.println(element);
    }
}
