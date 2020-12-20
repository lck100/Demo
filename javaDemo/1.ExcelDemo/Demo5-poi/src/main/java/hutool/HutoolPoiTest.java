package hutool;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

import java.util.*;

public class HutoolPoiTest {
    @Test
    public void testWriteArrayList() {
        // 1.构建数据
        List<String> row1 = new ArrayList<String>();
        Collections.addAll(row1, "aa", "bb", "cc", "dd", "ee");
        List<String> row2 = new ArrayList<String>();
        Collections.addAll(row2, "aa2", "bb2", "cc2", "dd2", "ee2");
        List<String> row3 = new ArrayList<String>();
        Collections.addAll(row3, "aa3", "bb3", "cc3", "dd3", "ee3");
        List<String> row4 = new ArrayList<String>();
        Collections.addAll(row4, "aa4", "bb4", "cc4", "dd4", "ee4");
        List<List<String>> rows = new ArrayList<List<String>>();
        Collections.addAll(rows, row1, row2, row3, row4);

        // 2.通过工具类创建Writer
        ExcelWriter writer = ExcelUtil.getWriter("hutoolExcelTest.xlsx");
        // 通过构造方法创建writer
        // ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        // 3.写入到excel
        writer.write(rows, true);

        // 4.关闭writer，释放内存
        writer.close();
    }

    @Test
    public void testWriteMap() {
        // 1.创建要写出的数据
        // 第一行
        Map<String, Object> row1 = new LinkedMap<String, Object>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", new Date());
        // 第二行
        Map<String, Object> row2 = new LinkedHashMap<String, Object>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", new Date());
        // 放入ArrayList中
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        Collections.addAll(rows, row1, row2);

        // 2.通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("hutoolExcelTest2.xlsx");

        // 3.一次性写出内容
        writer.write(rows);

        // 4.关闭writer，释放内存
        writer.close();
    }

    @Test
    public void testWriteBean() {
        // 1.构造写出数据
        TestBean row1 = new TestBean(1, "张三", "12345", 65.5f, true, new Date());
        TestBean row2 = new TestBean(2, "李四", "abcd#d", 35.5f, false, new Date());
        List<TestBean> rows = new ArrayList<TestBean>();
        Collections.addAll(rows, row1, row2);

        // 2.通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("hutoolExcelTest3.xlsx");

        // 3.一次性写出
        writer.write(rows);

        // 4.关闭writer，释放内存
        writer.close();
    }

    @Test
    public void testWriteBean2() {
        // 1.构造写出数据
        TestBean row1 = new TestBean(1, "张三", "12345", 65.5f, true, new Date());
        TestBean row2 = new TestBean(2, "李四", "abcd#d", 35.5f, false, new Date());
        List<TestBean> rows = new ArrayList<TestBean>();
        Collections.addAll(rows, row1, row2);

        // 2.通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("hutoolExcelTest3.xlsx");

        // 3.自定义标题别名
        writer.addHeaderAlias("id", "ID");
        writer.addHeaderAlias("name", "名字");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("score", "成绩");
        writer.addHeaderAlias("isPass", "是否通过");
        writer.addHeaderAlias("date", "日期");

        // 4.一次性写出
        writer.write(rows);

        // 5.关闭writer，释放内存
        writer.close();
    }

    @Test
    public void testWriteBigData() {
        // 1.构建数据
        List<List<String>> rows = new ArrayList<List<String>>();
        for (int i = 0; i < 65536; i++) {
            List<String> row1 = new ArrayList<String>();
            Collections.addAll(row1, "aa_" + i, "bb_" + i, "cc_" + i, "dd_" + i, "ee_" + i);
            rows.add(row1);
        }

        // 2.通过工具类创建Writer
        BigExcelWriter writer = ExcelUtil.getBigWriter("hutoolExcelTest.xlsx");

        // 3.写入到excel
        writer.write(rows, true);

        // 4.关闭writer，释放内存
        writer.close();
    }

    @Test
    public void testReadArrayList() {
        // 1.获取ExcelReader对象
        ExcelReader reader = ExcelUtil.getReader("hutoolExcelTest.xlsx");

        // 2.获取List<List<Object>>数据列表
        List<List<Object>> list = reader.read();

        // 3.处理获得的结果
        for (List<Object> objects : list) {
            System.out.println(objects);
        }
    }

    @Test
    public void testReadMap() {
        // 1.获取ExcelReader对象
        ExcelReader reader = ExcelUtil.getReader("hutoolExcelTest2.xlsx");

        // 2.获取List<Map<String,Object>>数据列表
        List<Map<String, Object>> list = reader.readAll();

        // 3.处理获得的结果
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            for (String s : set) {
                System.out.print(s + map.get(s) + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void testReadBean() {
        // 1.获取ExcelReader对象
        ExcelReader reader = ExcelUtil.getReader("hutoolExcelTest3.xlsx");

        // 2.获取List<Bean>数据列表
        List<TestBean> list = reader.readAll(TestBean.class);

        // 3.处理获得的结果
        for (TestBean testBean : list) {
            System.out.println(testBean.toString());
        }
    }

    @Test
    public void testRead2007BigData() {
        // 2.使用ExcelUtil快速读取
        ExcelUtil.read07BySax("hutoolExcelTest.xlsx", -1, createRowHandler());
        // 也可以构造对象读取
        // Excel07SaxReader  reader = new Excel07SaxReader(createRowHandler());
        // reader.read("hutoolExcelTest.xlsx",0);
    }

    // 1.行处理器
    private RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int i, int i1, List<Object> list) {
                for (Object o : list) {
                    System.out.println(o.toString());
                }
            }
        };
    }

    @Test
    public void testRead2003BigData() {
        // 2.使用ExcelUtil快速读取
        ExcelUtil.read03BySax("hutoolExcelTest.xls", -1, new RowHandler() {
            @Override
            public void handle(int i, int i1, List<Object> list) {
                for (Object o : list) {
                    System.out.println(o.toString());
                }
            }
        });
        // 也可以构造对象读取
        // Excel03SaxReader  reader = new Excel03SaxReader(createRowHandler());
        // reader.read("hutoolExcelTest.xls",0);
    }
}
