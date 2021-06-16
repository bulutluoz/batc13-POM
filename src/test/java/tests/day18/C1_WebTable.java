package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTable {
    /*
    login() metodun oluşturun ve oturum açın.
    ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
                ○ Username : manager
                ○ Password : Manager1!
    ● table() metodu oluşturun
                ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
                ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows() metodu oluşturun //tr
                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
                ○ 4.satirdaki(row) elementleri konsolda yazdırın.

     */

    @Test  (groups = "mini_regression")
    public void table(){
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        // -- //tbody//tr[1]//td bu body'deki 1.satirdaki data sayisini veriyor
        // bu locaterla bana 9 webelemneti dondugu icin

        System.out.println("tablodaki sutun sayisi = " + koalaResortPage.birinciSatirDatalar.size());

        // System.out.println(koalaResortPage.sutunBasliklari);
        // listemiz Webelementlerden olustugu icin direk yazdiramayiz
        // Yazdirmak icin for-each loop ile herbir web elementini alip, ustundeki texti yazdirmamiz gerekir

        for (WebElement each: koalaResortPage.sutunBasliklari
             ) {
            System.out.println(each.getText());
        }


        System.out.println(koalaResortPage.tbodyWebElement.getText());

        // Eger tum body'i tek bir web element olarak locate eder ve yazdirirsaniz
        // tum body'yi gorebilirsiniz
        // ancak bu cok kullanilmaz cunku bu durumda satir, sutun veya data'lari ayirma sansimiz yoktur
        // tum body tek bir element olarak yazdirilabilir ama islem yapmak zordur

        // Body'nin icinde bulunan td sayisini bulmak icin //tbody//td locate'ini kullaniriz

        System.out.println("Tablo body'sinde bulunan cell sayisi = " + koalaResortPage.bodydekiTumDataListesi.size() );

        Driver.closeDriver();

    }

    @Test (groups = "smoke")
    public void getRows(){
        //  ● printRows() metodu oluşturun //tr
        //                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //                ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.koalaResortLogin();

        //                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        //-----  //tbod//tr
        System.out.println("Tablodaki satir sayisi : " + koalaResortPage.satirlarListesi.size());

        //                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement each: koalaResortPage.satirlarListesi
             ) {
            System.out.println(each.getText());
        }

        //                ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(koalaResortPage.satirlarListesi.get(3).getText());


        // bir liste olusturmadan, parametre olarak satir numarasi kabul edip
        // girilen numaradaki satiri yazdiran bir method yaziniz

        // ornek 5.satir desem locate //tbody//tr[4]

        // 7. satiri yazdiralim
        System.out.println("=================");
        koalaResortPage.istenenSatiriYazdir(7);

        Driver.closeDriver();
    }

}
