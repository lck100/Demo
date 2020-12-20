package extend.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetConnectionByProp {
    public static void main(String[] args) throws IOException {
        // 1.获取properties文件路径
        String path = GetConnectionByProp.class.getClassLoader().getResource("extend/properties/jdbc.properties").getPath();
        // 2.实例化Properties对象并加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(path)));
        // 3.提取参数
        String driver = properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        // 4.打印结果（同样，这里不连接数据库）
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