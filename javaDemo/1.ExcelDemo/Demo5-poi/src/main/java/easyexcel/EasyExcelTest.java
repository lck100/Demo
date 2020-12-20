package easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyExcelTest {

    @Test
    public void testWrite() {
        // 封装测试数据到List中
        List<UserData> list = new ArrayList<UserData>();
        for (int i = 0; i < 10; i++) {
            UserData data = new UserData(i, "张三_" + i, "123456", new Date());
            list.add(data);
        }
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write("easyExcel.xlsx", UserData.class).sheet("sheet 11").doWrite(list);
    }

    @Test
    public void testRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read("easyExcel.xlsx", UserData.class, new UserDataListener()).sheet().doRead();
    }
}
