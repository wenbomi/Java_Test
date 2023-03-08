package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author 小米
 * @date 2022/11/17
 * select选择器对象的使用
 */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
        //1.获取xml文件路径
        String path = JsoupDemo05.class.getClassLoader().getResource("xml_demo/student.xml").getPath();
        //2.获取文件对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 查询 name 标签
        Elements elements = document.select("name");
        System.out.println(elements);

        // 查询 id 值为 1 的元素
        System.out.println("--------------");
        Elements elements1 = document.select("#1");
        System.out.println(elements1);

        // 获取student标签并且number数值为dangsheng_0001的age子标签
        //获取student标签并且number数值为dangsheng_0001
        System.out.println("--------------");
        Elements student = document.select("student[number=\"dangsheng_0001\"]");
        System.out.println(student);
        System.out.println("--------------");

        // 获取student标签并且number数值为dangsheng_0001的age子标签
        Elements age = document.select("student[number=\"dangsheng_0001\"] > age");
        System.out.println(age);

        // 获取age下的兄弟标签sex的内容
        System.out.println("-----------");
        Elements sex = document.select("student[number=\"dangsheng_0001\"] > age + sex");
        System.out.println(sex);

    }
}
