package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;
import java.util.List;

public class C4_WebTableDemoqa {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));

        //  2. Headers da bulunan department isimlerini yazdirin
        DemoqaPage demoqaPage=new DemoqaPage();

        for (WebElement w: demoqaPage.headerList
        ) {
            System.out.println(w.getText());
        }

        //  3.sutunun basligini yazdirin

        System.out.println("3.sutun basligi : " + demoqaPage.headerList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin

        System.out.println("====Tum Body====");
        System.out.println(demoqaPage.tumBodyElementi);

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("====Tum Hucreler====");

        for (WebElement each: demoqaPage.tumHucrelerListesi
        ) {
            System.out.println(each.getText());
        }
        System.out.println("tablodaki tum hucre sayisi : " + demoqaPage.tumHucrelerListesi.size());

        //  6. Tablodaki satir sayisini yazdirin

        System.out.println("Tablodaki Satir Sayisi :  " + demoqaPage.satirlarListesi.size());

        //  7. Tablodaki sutun sayisini yazdirin

        System.out.println("Tablodaki sutun sayisi : " + demoqaPage.headerList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        demoqaPage.sutunYazdir(Integer.parseInt(ConfigReader.getProperty("demoqa_istenen_sutun_no")));

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        demoqaPage.istenenKisininMaasiniYazdir("Kierra");

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //    sayisini girdigimde bana datayi yazdirsin

        demoqaPage.istenenHucreYazdir(2,2);




    }
}
