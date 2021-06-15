package tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {

        String excelPath="src/test/Resources/ulkeler.xlsx";

        FileInputStream fileInputStream=new FileInputStream(excelPath);

        // excel oldugu icin workBook olusturmamiz gerekiyor
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        // excel'in yapisi geregi workbook icinde sheet secmeliyiz

        Sheet sheet=workBook.getSheet("Sayfa1");

        // sayfadan sonra satira ulasmaliyiz
        // satir icin index girmeliyiz, index 0'dan baslar
        // ornegin 5.satira gitmek istiyorsak index: 4 olur

        Row row = sheet.getRow(4);

        // satirdan sonra cell secmemiz lazim
        // cell icin index girmeliyiz, index 0'dan baslar
        // ornegin 4. cell'e gitmek istiyorsak index: 3 olur

        Cell cell=row.getCell(2);

        // suanda cell variable'inin icinde workbook/ Sayfa1 / 5.satir / 4.cell bilgisi var

        System.out.println(cell);


    }

    @Test
    public void readExcel2() throws IOException {

        // 1.method'da cell'e ulasmak icin fis, workbook, sheet, row , cell olusturduk
        // ama cell'e ulasmak icin daha kisa bir yol olarak
        // fis ve workbook olusturduktan sonra
        // Cell cell= workbook.getsheet(sayfaAdi).getRow(Row index'i).getCell(Cell index'i)

        FileInputStream fileInputStream=new FileInputStream(ConfigReader.getProperty("excel_path"));
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Cell istenenHucre=workbook.
                                getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).
                                getRow(Integer.parseInt(ConfigReader.getProperty("excel_satir_index"))).
                                getCell(Integer.parseInt(ConfigReader.getProperty("excell_cell_index")));

        System.out.println(istenenHucre);

        // hucredeki bilginin ilk harfini yazdirin
        // Eger cell'deki bilgiyi sadece yazdirmak istersek, sout(cell) yazabiliriz
        // Ama cell'deki bilgi uzerinde manipulation yapmak istersek
        // oncelikle toString() method'u ile Cell'i String'e dataCasting yapmaliyiz

        System.out.println(istenenHucre.toString().substring(0,1));

        // excel sayfa1'deki satir sayisini bulun

        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getLastRowNum());

        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows());







    }







}
