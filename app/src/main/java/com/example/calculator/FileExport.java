package com.example.calculator;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FileExport {

    public static void writeToExcel(Context context, List<Order> orders, String fileName) throws Exception {
        //judge sdcard availability
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && getAvailableStorage(context) > 1000000) {
            Toast.makeText(context, "SD卡不可用！", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] title = {"ID", "FORMULA", "EXPECT_VALUE", "RESULT","ISPASS"};
        File file;
        File dir = new File(context.getExternalFilesDir(null).getPath());
        if (!dir.exists()) {
            boolean trymkdirs = dir.mkdirs();
            if(!trymkdirs){
                Toast.makeText(context, "无法生成文件", Toast.LENGTH_SHORT).show();
            }
        }
        //create file
        file = new File(dir, fileName + ".xls");
        //create Excel
        WritableWorkbook wwb;
        OutputStream os = new FileOutputStream(file);
        wwb = Workbook.createWorkbook(os);
        WritableSheet sheet = wwb.createSheet("测试结果", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            label = new Label(i, 0, title[i], getHeader());
            sheet.addCell(label);
        }
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            Label exp_id = new Label(0, i + 1, order.getExp_index());
            Label exp_for = new Label(1, i + 1, order.getExp_formula());
            Label exp_epv = new Label(2, i + 1, order.getExp_expectvalue());
            Label exp_res = new Label(3, i + 1, order.getExp_result());
            Label exp_isp = new Label(4, i + 1, String.valueOf(order.isExp_ispass()));
            sheet.addCell(exp_id);
            sheet.addCell(exp_for);
            sheet.addCell(exp_epv);
            sheet.addCell(exp_res);
            sheet.addCell(exp_isp);
        }
        wwb.write();
        wwb.close();
        Toast.makeText(context, "完成导出测试用例", Toast.LENGTH_SHORT).show();

    }

    public static WritableCellFormat getHeader() {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10,
                WritableFont.BOLD, true);
        try {
            font.setColour(Colour.PINK);
        } catch (WriteException e1) {
            e1.printStackTrace();
        }
        WritableCellFormat format = new WritableCellFormat(font);
        try {
            format.setAlignment(jxl.format.Alignment.CENTRE);
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            format.setBorder(Border.ALL, BorderLineStyle.THIN,
                    Colour.BLACK);
            format.setBackground(Colour.YELLOW);
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    private static long getAvailableStorage(Context context) {
        String root = context.getExternalFilesDir(null).getPath();
        //find disk usage
        StatFs statFs = new StatFs(root);
        long blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        return blockSize * availableBlocks;
    }

}
