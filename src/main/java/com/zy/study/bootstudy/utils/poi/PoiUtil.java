package com.zy.study.bootstudy.utils.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public class PoiUtil {

    private static final Logger logger = LoggerFactory.getLogger(PoiUtil.class);

    public final static String notnullerror = "请填入第{0}行的{1},{2}不能为空";
    public final static String errormsg = "第{0}行的{1}数据导入错误";

    public static <T> ByteArrayOutputStream exportExcel(List<T> models, Class<T> clazz) {

        try {
            if (!clazz.isAnnotationPresent(ModelTitle.class)) {
                throw new RuntimeException("请在此类型中加上ModelTitle注解");
            }

            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet();

            HSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            HSSFFont font = wb.createFont();
            font.setBold(true);
            font.setFontHeight((short) 400);
            titleStyle.setFont(font);

            HSSFRow row0 = sheet.createRow(0);
            HSSFCell titleCell = row0.createCell(0);

            ModelTitle modelTitle = clazz.getAnnotation(ModelTitle.class);
            titleCell.setCellValue(new HSSFRichTextString(modelTitle.name()));
            titleCell.setCellStyle(titleStyle);

            Field[] fields = clazz.getDeclaredFields();
            HSSFRow headRow = sheet.createRow(1);
            int colSzie = 0;

            /**
             * 设置表头样式
             */
            HSSFCellStyle headStyle = wb.createCellStyle();
            headStyle.setAlignment(HorizontalAlignment.CENTER);
            HSSFFont headFont = wb.createFont();
            headFont.setBold(true);
            headFont.setFontHeight((short) 240);
            headStyle.setFont(headFont);

            List<Integer> cells = new ArrayList<Integer>();
            Map<Integer,Field> modelFields = new HashMap<>();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ModelProp.class)) {
                    ModelProp modelProp = field.getAnnotation(ModelProp.class);
                    if (modelProp.colIndex() == -1){
                        continue;
                    }
                    cells.add(modelProp.colIndex());
                    modelFields.put(modelProp.colIndex(),field);
                    HSSFCell cell = headRow.createCell(modelProp.colIndex());
                    cell.setCellValue(new HSSFRichTextString(modelProp.name()));
                    cell.setCellStyle(headStyle);
                    colSzie++;

                    sheet.autoSizeColumn((short) modelProp.colIndex());
                    //sheet.setColumnWidth(modelProp.colIndex(), modelProp.name().length() * colsizeN + colsizeM);

                    // 设置列为下拉框格式
//                    if (map != null && map.get(new Integer(modelProp.colIndex())) != null) {
//                        DVConstraint constraint = DVConstraint
//                                .createExplicitListConstraint(map.get(modelProp.colIndex()));
//                        CellRangeAddressList regions = new CellRangeAddressList(2, rowSize, modelProp.colIndex(),
//                                modelProp.colIndex());
//                        HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
//                        sheet.addValidationData(dataValidation);
//                    }
                }
            }

            HSSFCellStyle cellStyle = wb.createCellStyle();
            HSSFDataFormat format = wb.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("@"));

            for (int i = 0; i < models.size(); i++) {
                T t = models.get(i);
                HSSFRow row = sheet.createRow(i+2);
                for (Integer integer : cells) {
                    HSSFCell cell = row.createCell(integer);

                    Field field = modelFields.get(integer);
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method method = clazz.getMethod(getMethodName);


                    Object value = method.invoke(t);
                    // 判断值的类型后进行强制类型转换
                     String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(
                                "yyyy-mm-dd");
                        textValue = sdf.format(date);
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        if (value == null) {
                            value = "";
                        }
                        textValue = value.toString();

                    }
                    cell.setCellValue(textValue);
                    cell.setCellStyle(cellStyle);

                }
            }
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colSzie - 1));


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            wb.write(outputStream);

            return outputStream;

        } catch (Exception e) {
            logger.error("exportExcel error", e);
            return null;
        }
    }
}
