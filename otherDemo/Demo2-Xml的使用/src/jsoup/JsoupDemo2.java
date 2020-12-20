package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        // 1.获取user.xml路径
        String path = JsoupDemo2.class.getClassLoader().getResource("user.xml").getPath();
        // 2.解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 2.1根据id属性值获取唯一的element对象
        Element elementById = document.getElementById("2");
        System.out.println(elementById);
        System.out.println("------------------------------------------");

        // 2.2 根据标签名称获取元素对象集合
        Elements elementsByTag = document.getElementsByTag("age");
        System.out.println(elementsByTag);
        System.out.println("------------------------------------------");

        // 2.3 根据属性名称获取元素对象集合
        Elements elementsByAttribute = document.getElementsByAttribute("id");
        System.out.println(elementsByAttribute);
        System.out.println("------------------------------------------");

        // 2.4 根据对应的属性名和属性值获取元素对象集合
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("id", "1");
        System.out.println(elementsByAttributeValue);
    }
}
