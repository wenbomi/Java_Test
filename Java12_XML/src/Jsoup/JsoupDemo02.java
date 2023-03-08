package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author 小米
 * @date 2022/11/17
 * Jsoup对象的使用
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //1.Jsoup：工具类，可以解析html或xml文档，返回Document
        // 第一种方式 parse(File in, String charsetName)：解析xml或html文件的。
//        String path = Jsoup.JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath(); // 先获取文件对象路径
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);

        //2. parse(String html)：解析xml或html字符串
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "<students>\n" +
//                "    <student number=\"dangsheng_0001\">\n" +
//                "        <name>xiaomi</name>\n" +
//                "        <age>18</age>\n" +
//                "        <sex>female</sex>\n" +
//                "    </student>\n" +
//                "    <student number=\"dangsheng_0002\">\n" +
//                "        <name>jiangjiang</name>\n" +
//                "        <age>26</age>\n" +
//                "        <sex>male</sex>\n" +
//                "    </student>\n" +
//                "</students>";
//        Document document = Jsoup.parse(str);
//        System.out.println(document);
//        System.out.println(document.getElementsByTag("name"));

        //3.parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = new URL("https://www.baidu.com/?tn=88093251_34_hao_pg");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);

    }
}
