package com.bdqn.edu.util;

import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.CourseResultMap;
import com.bdqn.edu.entity.Curriculum;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Excel工具类
 *
 * @since 2019-02-21
 */
public class ExcelUtil {

    public static final String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd");

    /**
     * Excel表格导出
     *
     * @param response
     * @param fileName
     * @param sheetName
     * @param titleName
     * @param begin
     * @param end
     * @param courseList
     * @throws IOException
     */
    public static void exportExcel(HttpServletResponse response,
                                   String fileName,
                                   String sheetName,
                                   String titleName,
                                   Date begin,
                                   Date end,
                                   List<Clazz> clazzList,
                                   List<CourseResultMap> courseList) throws IOException {
        // 获取时间长度
        int daysBetween = (int) (end.getTime() - begin.getTime()) / (60 * 60 * 24 * 1000) + 1;
        // 所有日期集合
        List<Date> dateList = new ArrayList<Date>();
        Long startTIme = begin.getTime();
        Long endTime = end.getTime();
        Long oneDay = 1000 * 60 * 60 * 24l;
        Long time = startTIme;
        while (time <= endTime) {
            dateList.add(new Date(time));
            time += oneDay;
        }

        // 声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 统一设置默认列宽
        // sheet.setDefaultColumnWidth(6);
        sheet.setColumnWidth(0, 6 * 256);
        // 创建第0行 也就是标题
        HSSFRow titleRow = sheet.createRow(0);
        // 设备标题的高度
        titleRow.setHeightInPoints(34);
        // 创建标题样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        // 创建字体样式
        HSSFFont titleFont = workbook.createFont();
        // 设置斜体
        titleFont.setItalic(true);
        // 设置字体类型
        titleFont.setFontName("宋体");
        // 设置字体大小
        titleFont.setFontHeightInPoints((short) 22);
        // 为标题样式设置字体样式
        titleStyle.setFont(titleFont);
        // 垂直居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 水平居中
        titleStyle.setAlignment(HorizontalAlignment.CENTER);

        // lastCol
        int lastCol = daysBetween * 3;

        if (lastCol < 21) {
            lastCol = 21;
        }

        HSSFCell cell1 = titleRow.createCell(0);// 创建标题第一列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                lastCol)); // 合并列标题
        cell1.setCellValue(titleName); // 设置值标题
        cell1.setCellStyle(titleStyle); // 设置标题样式

        // 创建头部样式
        HSSFCellStyle headerRow1Style = workbook.createCellStyle();
        HSSFCellStyle headerRow2Style = workbook.createCellStyle();
        HSSFFont headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 9);
        headerFont.setBold(true);
        headerFont.setFontName("宋体");

        headerRow1Style.setFont(headerFont);
        headerRow1Style.setVerticalAlignment(VerticalAlignment.CENTER);
        headerRow1Style.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        headerRow1Style.setBorderTop(BorderStyle.THIN);
        headerRow1Style.setBorderBottom(BorderStyle.THIN);
        headerRow1Style.setBorderLeft(BorderStyle.THIN);
        headerRow1Style.setBorderRight(BorderStyle.THIN);


        headerRow2Style.setFont(headerFont);
        headerRow2Style.setVerticalAlignment(VerticalAlignment.CENTER);
        headerRow2Style.setAlignment(HorizontalAlignment.CENTER);
        // 边框
        headerRow2Style.setBorderTop(BorderStyle.THIN);
        headerRow2Style.setBorderBottom(BorderStyle.THIN);
        headerRow2Style.setBorderLeft(BorderStyle.THIN);
        headerRow2Style.setBorderRight(BorderStyle.THIN);

        // 头部行
        HSSFRow headerRow1 = sheet.createRow(1);
        HSSFRow headerRow2 = sheet.createRow(2);
        headerRow1.setHeightInPoints((short) 23);
        headerRow1Style.setBorderTop(BorderStyle.MEDIUM);

        headerRow2Style.setBorderBottom(BorderStyle.MEDIUM);
        headerRow2.setHeightInPoints((short) 24);

        // 单独设置 班级
        HSSFCell clazzCell1 = headerRow1.createCell(0);
        HSSFCell clazzCell2 = headerRow2.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
        clazzCell1.setCellValue("班级");

        clazzCell1.setCellStyle(headerRow1Style);
        clazzCell2.setCellStyle(headerRow2Style);
        // 头部设置
        for (int i = 0; i < dateList.size(); i++) {
            Date date = dateList.get(i);
            HSSFCell dateCell = headerRow1.createCell(i * 3 + 1);
            HSSFCell dateCell2 = headerRow1.createCell(i * 3 + 2);
            HSSFCell dateCell3 = headerRow1.createCell(i * 3 + 3);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, i * 3 + 1,
                    (i + 1) * 3));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            dateCell.setCellValue(DATE_FORMAT.format(date) + "  " + weekDays[w]);
            dateCell.setCellStyle(headerRow1Style);
            dateCell2.setCellStyle(headerRow1Style);
            dateCell3.setCellStyle(headerRow1Style);

            HSSFCell headerCell1 = headerRow2.createCell(i * 3 + 1);
            HSSFCell headerCell2 = headerRow2.createCell(i * 3 + 2);
            HSSFCell headerCell3 = headerRow2.createCell(i * 3 + 3);
            headerCell1.setCellValue("课程名称");
            headerCell2.setCellValue("教员");
            headerCell3.setCellValue("地点");

            // 单独设置列宽
            sheet.setColumnWidth(i * 3 + 1, 256 * 10 + 210);
            sheet.setColumnWidth(i * 3 + 2, 256 * 7 + 210);
            sheet.setColumnWidth(i * 3 + 3, 256 * 7 + 210);

            headerCell1.setCellStyle(headerRow2Style);
            headerCell2.setCellStyle(headerRow2Style);
            headerCell3.setCellStyle(headerRow2Style);
        }

        // 根据 clazzName 分离 CourseResultMap
        Map<String, List<CourseResultMap>> clazzMap = courseList.stream().collect(Collectors.groupingBy(CourseResultMap::getClazzName));

        // 创建 data 样式
        HSSFCellStyle dataRowStyle = workbook.createCellStyle();
        dataRowStyle.setFont(headerFont);
        dataRowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataRowStyle.setAlignment(HorizontalAlignment.CENTER);
        // 背景颜色
        dataRowStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        dataRowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 边框
        dataRowStyle.setBorderTop(BorderStyle.THIN);
        dataRowStyle.setBorderBottom(BorderStyle.THIN);
        dataRowStyle.setBorderLeft(BorderStyle.THIN);
        dataRowStyle.setBorderRight(BorderStyle.THIN);
        // 自动换行
        dataRowStyle.setWrapText(true);
        for (int i = 0; i < clazzList.size(); i++) {
            String clazzName = clazzList.get(i).getName();
            // 创建 班级 一行
            HSSFRow dataRow = sheet.createRow(3 + i);
            dataRow.setHeightInPoints((short) 53);
            // 创建 班级名称 Cell
            HSSFCell clazzCell = dataRow.createCell(0);
            clazzCell.setCellStyle(dataRowStyle);
            clazzCell.setCellValue(clazzName);
            List<CourseResultMap> tempCourseList = clazzMap.get(clazzName);
            if (tempCourseList == null) {
                tempCourseList = new ArrayList<>();
                tempCourseList.add(new CourseResultMap());
            }
            // 添加课程数据
            for (int k = 0; k < dateList.size(); k++) {
                for (int j = 0; j < tempCourseList.size(); j++) {
                    HSSFCell dataCell1 = dataRow.createCell(k * 3 + 1);
                    HSSFCell dataCell2 = dataRow.createCell(k * 3 + 2);
                    HSSFCell dataCell3 = dataRow.createCell(k * 3 + 3);
                    dataCell1.setCellStyle(dataRowStyle);
                    dataCell2.setCellStyle(dataRowStyle);
                    dataCell3.setCellStyle(dataRowStyle);
                    if (dateList.get(k).equals(tempCourseList.get(j).getBegin())) {
                        CourseResultMap courseResultMap = tempCourseList.get(j);
                        Curriculum curriculum = courseResultMap.getCurriculum();
                        String[] curriculumChapter = curriculum.getChapter().split("-");
                        if (curriculumChapter.length == 2) {
                            dataCell1.setCellValue(curriculumChapter[0] + "(" + courseResultMap.getPeriod() + ")\r\n" + curriculumChapter[1]);
                        } else {
                            dataCell1.setCellValue("(" + courseResultMap.getPeriod() + ")\r\n" + curriculumChapter[0]);
                        }
                        dataCell2.setCellValue(courseResultMap.getTeacher().getName() + "\r\n课时：" + curriculum.getHour());
                        dataCell3.setCellValue(courseResultMap.getRoom().getName());
                        break;
                    }
                }
            }
        }

        // 将文件存到浏览器设置的下载位置
        String filename = fileName + ".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
        OutputStream out = response.getOutputStream();
        try {
            workbook.write(out);// 将数据写出去
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}