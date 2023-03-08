package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author 小米
 * @date 2022/11/17
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        String path = JsoupTest.class.getClassLoader().getResource("xml_demo/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);
        System.out.println(elements.size());

    }
}
