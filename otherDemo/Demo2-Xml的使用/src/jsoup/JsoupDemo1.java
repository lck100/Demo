package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 1.获取user.xml路径
        String path = JsoupDemo1.class.getClassLoader().getResource("user.xml").getPath();
        // 2.解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3.获取元素对象Element
        Elements elements = document.getElementsByTag("users");
        // 4.打印结果
        System.out.println(elements);
    }
}
