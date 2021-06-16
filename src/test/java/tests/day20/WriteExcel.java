package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        String path="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);



        Workbook workbook= WorkbookFactory.create(fileInputStream);


        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(4).createCell(4).setCellValue("100000");
        workbook.getSheetAt(0).getRow(5).createCell(4).setCellValue("10000");
        workbook.getSheetAt(0).getRow(9).createCell(4).setCellValue("2100000");


        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);





    }
}
