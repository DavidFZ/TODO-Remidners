package edu.square.utils;

import edu.square.entity.Exportable;
import edu.square.entity.Reminder;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

import static edu.square.model.view1.widget.ReminderModel.queryAllEntities;

public class ExportExcelUtil {
    public static void exportAllFromDB(Class<? extends Exportable> exportClass) {
        try {
            Workbook workbook = new HSSFWorkbook();
            workbook.createSheet(exportClass.getName());

            //set header
            Field[] fields = Reminder.class.getDeclaredFields();
            HSSFRow headerRow = (HSSFRow) workbook.getSheet(exportClass.getName()).createRow(0);
            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = headerRow.createCell(i);
                cell.setCellValue(fields[i].getName());
            }

            //insert data
            List<Reminder> list = queryAllEntities();
            for (int i = 0; i < list.size(); i++) {
                HSSFRow row = (HSSFRow) workbook.getSheet(exportClass.getName()).createRow(i + 1);
                Reminder reminder = list.get(i);
                for (int j = 0; j < fields.length; j++) {
                    HSSFCell cell = row.createCell(j);
//                    Object value = fields[j].get(reminder);
                    Object value = reminder.getFieldValue(j);
                    cell.setCellValue(value != null ? value.toString() : "");
                }
            }

            //save file
            FileOutputStream fileOut = new FileOutputStream(LocalDateTime.now().toString()+"_export.xls");
            workbook.write(fileOut);
            fileOut.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        exportAllFromDB(Reminder.class);
    }
}
