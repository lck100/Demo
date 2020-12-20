package poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class PoiTest {
    @Test
    public void testWrite2003() throws IOException {// 测试2003版本的写入excel
        // 1.创建新的工作簿
        Workbook workbook = new HSSFWorkbook();

        // 2.在工作簿中创建工作表，可以选择写入名字，也可以不传入，则缺省值为Sheet0
        Sheet sheet = workbook.createSheet("Sheet 11");

        // 3.1创建行（row 1）
        Row row1 = sheet.createRow(0);// 0表示第1行，1表示第2行，依次如此...

        // 4.1创建单元格(col 1-1）
        Cell cell_11 = row1.createCell(0);// 表示第1行的第一个单元格，也可以说是第一行第一列的单元格
        cell_11.setCellValue("姓名");// 为该单元格赋值
        // 4.2创建单元格（col 1-2）
        Cell cell_12 = row1.createCell(1);// 表示第1行第2列的单元格
        cell_12.setCellValue("张三");// 为该单元格赋值

        // 3.2创建第二行(row 2）
        Row row2 = sheet.createRow(1);// 1表示第2行

        // 4.2创建单元格(col 2-1）
        Cell cell_21 = row2.createCell(0);// 表示第2行第一个单元格，0表示第一个单元格（第1列），1表示第二个单元格（第2列）
        cell_21.setCellValue("性别");// 为该单元格赋值
        // 4.2 创建单元格（col 2-2）
        Cell cell_22 = row2.createCell(1);// 表示第2行第2列的单元格
        cell_22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));// 为该单元格赋值

        // 5.生成excel文件
        FileOutputStream out = new FileOutputStream("统计表.xls");// 新建输出流，注意文件名后缀必须是xls，因为是2003版本的excel文件
        workbook.write(out);// 把相应的Excel 工作簿存盘
        out.close();// 操作结束，关闭流
        System.out.println("excel文件生成成功");// 给出提示
    }

    @Test
    public void testWrite2007() throws IOException {// 测试2007及以上版本的写入excel
        // 1.创建新的工作簿，只有对象变化了
        Workbook workbook = new XSSFWorkbook();

        // 2.在工作簿中创建工作表，可以选择写入名字，也可以不传入，则缺省值为Sheet0
        Sheet sheet = workbook.createSheet("Sheet 11");

        // 3.1创建行（row 1）
        Row row1 = sheet.createRow(0);// 0表示第1行，1表示第2行，依次如此...

        // 4.1创建单元格(col 1-1）
        Cell cell_11 = row1.createCell(0);// 表示第1行的第一个单元格，也可以说是第一行第一列的单元格
        cell_11.setCellValue("姓名");// 为该单元格赋值
        // 4.2创建单元格（col 1-2）
        Cell cell_12 = row1.createCell(1);// 表示第1行第2列的单元格
        cell_12.setCellValue("张三");// 为该单元格赋值

        // 3.2创建第二行(row 2）
        Row row2 = sheet.createRow(1);// 1表示第2行

        // 4.2创建单元格(col 2-1）
        Cell cell_21 = row2.createCell(0);// 表示第2行第一个单元格，0表示第一个单元格（第1列），1表示第二个单元格（第2列）
        cell_21.setCellValue("性别");// 为该单元格赋值
        // 4.2 创建单元格（col 2-2）
        Cell cell_22 = row2.createCell(1);// 表示第2行第2列的单元格
        cell_22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));// 为该单元格赋值

        // 5.生成excel文件
        FileOutputStream out = new FileOutputStream("统计表.xlsx");// 新建输出流，注意文件名后缀必须是xlsx，因为是2007及以上版本的excel文件
        workbook.write(out);// 把相应的Excel 工作簿存盘
        out.close();// 操作结束，关闭流
        System.out.println("excel文件生成成功");// 给出提示
    }

    @Test
    public void testWrite2003BigData() throws IOException {// 在2003版本的excel中写入大量数据
        long begin = System.currentTimeMillis();// 记录开始时间

        // 1.创建一个HSSFWorkbook对象
        Workbook workbook = new HSSFWorkbook();

        // 2.创建Sheet对象
        Sheet sheet = workbook.createSheet();

        // 批量添加Row
        for (int rowNum = 0; rowNum < 65536; rowNum++) {// xls文件最大支持65536行
            // 3.创建Row对象
            Row row = sheet.createRow(rowNum);
            // 批量添加Cell单元格
            for (int cellNum = 0; cellNum < 5; cellNum++) {
                // 4.创建单元格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);// 赋值为单元格
            }
        }

        // 5.写入文件
        FileOutputStream out = new FileOutputStream("2003版写入大量数据.xls");// 创建流
        workbook.write(out);// 写入
        out.close();// 操作结束，关闭文件

        long end = System.currentTimeMillis();// 记录结束时间
        System.out.println((double) (end - begin) / 1000);// 打印结束时间
    }

    @Test
    public void testWrite2007BigData() throws IOException {
        long begin = System.currentTimeMillis();// 记录开始时间

        // 1.创建一个XSSFWorkbook对象，也改此处
        Workbook workbook = new XSSFWorkbook();

        // 2.创建Sheet对象
        Sheet sheet = workbook.createSheet();

        // 批量添加Row
        for (int rowNum = 0; rowNum < 65536; rowNum++) {// xls文件最大支持65536行
            // 3.创建Row对象
            Row row = sheet.createRow(rowNum);
            // 批量添加Cell单元格
            for (int cellNum = 0; cellNum < 5; cellNum++) {
                // 4.创建单元格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);// 赋值为单元格
            }
        }

        // 5.写入文件
        FileOutputStream out = new FileOutputStream("2007版写入大量数据.xlsx");// 创建流
        workbook.write(out);// 写入
        out.close();// 操作结束，关闭文件

        long end = System.currentTimeMillis();// 记录结束时间
        System.out.println((double) (end - begin) / 1000);// 打印结束时间
    }

    @Test
    public void testWrite2007BigDataBySXSSF() throws IOException {
        long begin = System.currentTimeMillis();// 记录开始时间

        // 1.创建一个SXSSFWorkbook对象，也只改此处
        Workbook workbook = new SXSSFWorkbook();

        // 2.创建Sheet对象
        Sheet sheet = workbook.createSheet();

        // 批量添加Row
        for (int rowNum = 0; rowNum < 65536; rowNum++) {// xls文件最大支持65536行
            // 3.创建Row对象
            Row row = sheet.createRow(rowNum);
            // 批量添加Cell单元格
            for (int cellNum = 0; cellNum < 5; cellNum++) {
                // 4.创建单元格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);// 赋值为单元格
            }
        }

        // 5.写入文件
        FileOutputStream out = new FileOutputStream("2007版写入大量数据.xlsx");// 创建流
        workbook.write(out);// 写入
        out.close();// 操作结束，关闭文件

        // 6.清除临时文件
        ((SXSSFWorkbook) workbook).dispose();

        long end = System.currentTimeMillis();// 记录结束时间
        System.out.println((double) (end - begin) / 1000);// 打印结束时间
    }

    @Test
    public void testRead2003() throws IOException {
        // 1.通过流读入2003版本的excel文件
        InputStream is = new FileInputStream("统计表.xls");// 注意文件后缀

        // 2.读工作簿的工作表
        Workbook workbook = new HSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);// 0表示第一张工作表

        // 3.读取第一行
        Row row = sheet.getRow(0);

        // 4.读取第一列
        Cell cell = row.getCell(0);

        // 5.输出单元内容
        System.out.println(cell.getStringCellValue());

        // 6.操作结束，关闭文件
        is.close();
    }

    @Test
    public void testRead2007() throws IOException {
        // 1.通过流读入2007版本的excel文件
        InputStream is = new FileInputStream("统计表.xlsx");// 注意文件后缀

        // 2.读工作簿的工作表，修改为XSSFWorkbook对象
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);// 0表示第一张工作表

        // 3.读取第一行
        Row row = sheet.getRow(0);

        // 4.读取第一列
        Cell cell = row.getCell(0);

        // 5.输出单元内容
        System.out.println(cell.getStringCellValue());

        // 6.操作结束，关闭文件
        is.close();
    }

    @Test
    public void testCellType() throws IOException {
        // 1.通过流读入2007版本的excel文件
        InputStream is = new FileInputStream("学生表.xlsx");// 注意文件后缀

        // 2.读工作簿的工作表，修改为XSSFWorkbook对象
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);// 0表示第一张工作表

        // 3.读取标题行
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) { //行不为空
            // 读取cell
            int cellCount = rowTitle.getPhysicalNumberOfCells();// getPhysicalNumberOfCells()方法可以获取有多少列被填充了数据
            for (int cellNum = 0; cellNum < cellCount; cellNum++) { // 循环遍历读取标题行的单元格
                Cell cell = rowTitle.getCell(cellNum);// 获取单元格对象Cell
                if (cell != null) {// 单元格不为空
                    // int cellType = cell.getCellType();// 获取单元格类型
                    String cellValue = cell.getStringCellValue();// 一般标题行的单元格都是字符串类型的
                    System.out.print(cellValue + "|");// 打印输出
                }
            }
            System.out.println();// 换行
        }

        // 4.读取表格内容（不包括第一行即标题行）
        int rowCount = sheet.getPhysicalNumberOfRows();// 获取有多少行填充了数据
        for (int rowNum = 1; rowNum < rowCount; rowNum++) { // 从第二行开始读取内容，因为第一行是标题行
            Row rowData = sheet.getRow(rowNum);// 获取行数据对象Row
            if (rowData != null) {// 行不为空
                // 读取cell
                int cellCount = rowTitle.getPhysicalNumberOfCells();// 获取该行有多少个单元格
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {// 循环读取该行的所有单元格
                    System.out.print("【" + (rowNum + 1) + "-" + (cellNum + 1) + "】");
                    Cell cell = rowData.getCell(cellNum);// 获取单元格对象Cell
                    if (cell != null) {
                        int cellType = cell.getCellType();// 获取单元格数据的类型
                        //判断单元格数据类型
                        String cellValue = "";
                        switch (cellType) {
                            case HSSFCell.CELL_TYPE_STRING://字符串
                                System.out.print("【STRING】");
                                cellValue = cell.getStringCellValue();// getStringCellValue()方法获取字符串类型的单元格数据
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN://布尔
                                System.out.print("【BOOLEAN】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());// getBooleanCellValue()方法获取布尔类型的单元格数据
                                break;
                            case HSSFCell.CELL_TYPE_BLANK://空
                                System.out.print("【BLANK】");
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                System.out.print("【NUMERIC】");
                                //cellValue = String.valueOf(cell.getNumericCellValue());
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {//日期
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();// getDateCellValue()方法获取日期类型的单元格数据
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                } else {
                                    // 不是日期格式，则防止当数字过长时以科学计数法显示
                                    System.out.print("【转换成字符串】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                System.out.print("【数据类型错误】");
                                break;
                        }

                        System.out.println(cellValue);
                    }
                }
            }
        }

        // 5.操作结束，关闭文件
        is.close();
    }

    @Test
    public void testFormula() throws IOException {
        // 1.通过流读入2007版本的excel文件
        InputStream is = new FileInputStream("公式表.xlsx");// 注意文件后缀

        // 2.读工作簿的工作表，修改为XSSFWorkbook对象
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);// 0表示第一张工作表

        // 3.读取公式所在行（此例中公式在第6行中，但在代码中应该写5，从0开始）
        Row row = sheet.getRow(5);

        // 4.读取第一列
        Cell cell = row.getCell(0);

        // 5.公式计算器
        FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(workbook);// 注意2003版本和2007版本的excel文件是不同的公式计算器

        // 6.输出单元格内容
        int cellType = cell.getCellType();// 获取单元格类型
        switch (cellType) {// 判断单元格类型是否是公式
            case Cell.CELL_TYPE_FORMULA:// 公式
                String formula = cell.getCellFormula(); //  getCellFormula()方法得到公式
                System.out.println(formula);// 打印公式

                CellValue evaluate = formulaEvaluator.evaluate(cell);// 计算公式的值
                //String cellValue = String.valueOf(evaluate.getNumberValue());
                String cellValue = evaluate.formatAsString();// 将值转换成字符串
                System.out.println(cellValue);// 打印值

                break;
        }

        // 7.操作结束，关闭文件
        is.close();
    }
}
