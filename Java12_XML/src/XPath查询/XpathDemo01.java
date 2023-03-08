package XPath查询;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 小米
 * @date 2022/11/17
 * Xpath插叙入门语法
 */
public class XpathDemo01 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        // 获取student.xml文档的文件路径
        String path = XpathDemo01.class.getClassLoader().getResource("xml_demo/student.xml").getPath();
        // 获取文件对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 根据document对象，创建JXdocument对象
        JXDocument jxDocument = new JXDocument(document);
        // 结合Xpath语法知识进行查询
        // 查询所有的student标签
        List<JXNode> jxNodeList = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodeList) {
            System.out.println("------------");
            System.out.println(jxNode);
        }
        System.out.println("---------");
        // 查询所有的student标签下的sex标签
        List<JXNode> jxNodeList2 = jxDocument.selN("//student/sex");
        for (JXNode jxNode_sex : jxNodeList2) {
            System.out.println("------------");
            System.out.println(jxNode_sex);
        }

        // 查询所有的student标签下的带有id属性的name标签
        System.out.println("------------");
        List<JXNode> jxNodeList3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode_name : jxNodeList3) {
            System.out.println("------------");
            System.out.println(jxNode_name);
        }

        // 查询所有的student标签下的带有id属性的name标签 且id属性值为1的元素
        System.out.println("------最后一条------");
        List<JXNode> jxNodeList4 = jxDocument.selN("//student/name[@id='1']");
        for (JXNode jxNode_ds : jxNodeList4) {
            System.out.println(jxNode_ds);
            System.out.println("------------");
        }
    }
}
