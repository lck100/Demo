package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        // 1.获取user.xml路径
        String path = JsoupDemo3.class.getClassLoader().getResource("user.xml").getPath();
        // 2.解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3. 通过id属性值获取唯一的元素对象
        Element element = document.getElementById("1");

        // 3.1 获取属性值
        String id = element.attr("id");
        System.out.println(id);
        System.out.println("------------------------------------------");

        // 3.2 获取文本内容
        String text = element.text();
        System.out.println(text);
        System.out.println("------------------------------------------");

        // 3.3 获取包括html标签在内的所有内容
        String html = element.html();
        System.out.println(html);
    }
}
/**
 * 打印结果：
 * 1
 * ------------------------------------------
 * 张三 12 f
 * ------------------------------------------
 * <name>
 *  张三
 * </name>
 * <age>
 *  12
 * </age>
 * <sex>
 *  f
 * </sex>
 */