package extend.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class GetConnectionByXml {
    public static void main(String[] args) throws IOException {
        // 1.获取database.xml的路径
        String path = GetConnectionByXml.class.getClassLoader().getResource("extend/xml/database.xml").getPath();
        // 2.加载xml文件得到Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3.获取Elements元素对象
        Elements jdbc = document.getElementsByTag("jdbc");
        // 4.获取参数
        String driver = jdbc.select("driver").text();
        String url = jdbc.select("url").text();
        String username = jdbc.select("username").text();
        String password = jdbc.select("password").text();
        // 5.打印结果（这里就不连接数据库了）
        System.out.println(driver + "\n" + url + "\n" + username + "\n" + password);
    }
}
/**
 * 打印结果：
 * com.mysql.jdbc.Driver
 * jdbc:mysql://localhost:3306/test
 * root
 * root
 */