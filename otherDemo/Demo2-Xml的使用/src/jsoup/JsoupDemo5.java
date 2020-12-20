package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        // 1.获取user.xml路径
        String path = JsoupDemo3.class.getClassLoader().getResource("user.xml").getPath();
        // 2.解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3.根据document对象，创建JXDocument对象
        JXDocument jxDocument=new JXDocument(document);

        // 4.结合xpath语法查询
        // 4.1 查询所有user标签
        List<JXNode> jxNodes1 = jxDocument.selN("//user");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode.getElement());
        }
        System.out.println("------------------------------------------");

        // 4.2 查询所有user标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//user/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode.getElement());
        }
        System.out.println("------------------------------------------");

        // 4.3 查询users标签下带有id属性的user标签
        List<JXNode> jxNodes3 = jxDocument.selN("//users/user[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode.getElement());
        }
        System.out.println("------------------------------------------");

        // 4.4 询users标签下带有id属性的user标签，并且id属性值为"1"
        List<JXNode> jxNodes4 = jxDocument.selN("//users/user[@id='2']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode.getElement());
        }
    }
}
