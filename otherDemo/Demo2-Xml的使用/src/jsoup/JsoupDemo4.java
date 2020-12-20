package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        // 1.获取user.xml路径
        String path = JsoupDemo3.class.getClassLoader().getResource("user.xml").getPath();
        // 2.解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3.获取Elements对象
        Elements users = document.getElementsByTag("users");

        // 3.1 根据id来获取
        Elements elements_id = users.select("#1");
        System.out.println(elements_id);
        System.out.println("------------------------------------------");

        // 3.2 根据属性名来获取
        Elements elements_attr = users.select("[id]");
        System.out.println(elements_attr);
        System.out.println("------------------------------------------");

        // 3.3 根据属性值来匹配
        Elements elements_attr_val = users.select("[id='2']");
        System.out.println(elements_attr_val);
        System.out.println("------------------------------------------");

        // 3.4 获取子元素
        Elements elements_child = users.select("user > name");
        System.out.println(elements_child);
    }
}
