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
 * 操作Document/Element对象
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //1. 获取students.xml文件路径
        String path = JsoupDemo03.class.getClassLoader().getResource("xml_demo/student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);

        System.out.println("--------");
        // 3.1 获取属性名为id的元素对象
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);
        System.out.println("--------");
        // 3。2 获取number="dangsheng_0002"的对象
        Elements elements1 = document.getElementsByAttributeValue("number", "dangsheng_0002");
        System.out.println(elements1);
        System.out.println("--------");
        //3.3 获取元素属性值的元素对象
        Element elementById = document.getElementById("1");
        System.out.println(elementById);
    }
}
