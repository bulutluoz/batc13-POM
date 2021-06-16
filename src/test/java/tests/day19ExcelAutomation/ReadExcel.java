package tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        // getLastRowNum() son satirin index'ini verir ,  satir sayisini bulmak istersek sonuca 1 ekleriz
        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows());
        // getPhysicalNumberOfRows() ise aktif olarak bilgi iceren satir sayisini verir
        // 0'dan baslamaz, sayma sayilarini kullanir


        // Excelin 2.sayfasinda bazi satirlari kullanip, bazilarini kullanmadik
        // bu durumda sonSatirIndex'i ve fizikiKullanilanSatirSayisi degerlerini bulalim

        System.out.println("2.sayfa son satir index i : " + workbook.getSheetAt(1).getLastRowNum());
        System.out.println("2.sayfa fiziki kullanilan satir sayisi : " + workbook.getSheetAt(1).getPhysicalNumberOfRows());



        // excel'de bulunan tum ulkelerin turkce isimlerini yazdirin
        // yani her satirdaki 2.index'deki bilgi isteniyor


        int sonSatirIndexi=workbook.getSheetAt(0).getLastRowNum();

        for (int index=1 ; index<=sonSatirIndexi ; index++){

            String baskentIsmi= workbook.getSheetAt(0).getRow(index).getCell(3).toString();

            System.out.println((index+1)+ ". satirdaki baskent ismi " + baskentIsmi);
        }

        // Excel'deki tum datalari Class'imiza almak istersek
        // Bunun icin datalari bir java objesine eklememiz gerekir

        // boyle bir bilgiyi depolayabileyecegimiz java objesi map olabilir
        // Map'e depolamak icin sutunlardan birini key
        // digerlerini virgulle birbirine ekleyerek olusturacagim String'i ise value yapabilirim

        Map<String,String> ulkelerMap = new HashMap<>();
        String key="";
        String value="";

        for (int index=1 ; index<=sonSatirIndexi ; index++){

            key=workbook.getSheetAt(0).getRow(index).getCell(0).toString();

            value= workbook.getSheetAt(0).getRow(index).getCell(1).toString() + ", "+
                    workbook.getSheetAt(0).getRow(index).getCell(2).toString() + ", "+
                    workbook.getSheetAt(0).getRow(index).getCell(3).toString();

            ulkelerMap.put(key,value);
        }

        System.out.println(ulkelerMap);

        fileInputStream.close();
        workbook.close();

    }







}
