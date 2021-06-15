package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class C1_WebTableTekrar1 {

    //1. Bir metod oluşturun : printData(int row, int column);
    //	a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //	printData metodu bu 	hücredeki(cell) veriyi yazdırmalıdır.
    //2. Baska bir Test metodu oluşturun: printDataTest();
    //	a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //	b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //	c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    @Test
    public void test01(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.koalaResortLogin();

        // istedigimiz satir ve sutun sayisini yazdigimizda
        // bize o hucredeki yaziyi getiren method'u calistiralim
        koalaResortPage.istenenHucreyiYazdir(3,6);

        // 5 satir 4. sutundaki bilginin Lucio McKenzie MD oldugunu test edin
        // //tbody//tr[5]//td[4]

        String actualHucreYazisi = koalaResortPage.dataStringBul(5,4);

        Assert.assertEquals(actualHucreYazisi,ConfigReader.getProperty("webTableExpectedData"));

    }
}
