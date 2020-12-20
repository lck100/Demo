import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        // 对获取内容进行转码
        String username = req.getParameter("username");
        String s = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        System.out.println(username);
    }
}
