package com.yesong.learn;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted;

/**
 * @program: lease-parent
 * @description: excel工具类
 * @author: chengjie
 * @create: 2018-05-30 15:08
 **/
public class ExcelUtil {

    /**
     * 读取excel文件
     * /mnt/service/data-clean/清洗imei_type.xlsx
     * /Users/jimi/Documents/清洗imei_type.xlsx
     * @param fileName
     * @return
     * @throws Exception
     */
    public static final List<String> readExcel(String fileName) throws Exception {
        return readExcelList(fileName).stream().map(p -> p.get(0)).collect(Collectors.toList());
    }

    /**
     * 读取excel文件
     * /mnt/service/data-clean/清洗imei_type.xlsx
     * /Users/jimi/Documents/清洗imei_type.xlsx
     * @param fileName
     * @return
     * @throws Exception
     */
    public static final List<List<String>> readExcelList(String fileName) throws Exception {
        return readExcelList(fileName, 0, 2, 1);
    }

    /**
     * 读取excel文件
     * /mnt/service/data-clean/清洗imei_type.xlsx
     * /Users/jimi/Documents/清洗imei_type.xlsx
     * @param fileName
     * @param sheeIndex
     * @param rowIdex 第几行开始
     * @param colIndex 读取列数
     * @return
     * @throws Exception
     */
    public static final List<List<String>> readExcelList(String fileName, int sheeIndex, int rowIdex, int colIndex) throws Exception {
        File file = new File(fileName);
        List<List<String>> list = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = null;
            try {
                workbook = new XSSFWorkbook(file);
            } catch (Exception e) {
                workbook = new HSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(sheeIndex);
            Iterator<Row> iterator = sheet.iterator();
            int rownum = 0;
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                if (++ rownum < rowIdex) {
                    continue;
                }
                List<String> rowList = new ArrayList();
                for (int i = 0; i < colIndex; i ++) {
                    Cell cell = nextRow.getCell(i);
                    String value = getCellValue(cell);
                    rowList.add(value);
                }
                list.add(rowList);
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    public static final String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (isCellDateFormatted(cell)) {
                    cellValue = new DataFormatter().formatCellValue(cell);
                } else {
                    cellValue = df.format(cell.getNumericCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

}