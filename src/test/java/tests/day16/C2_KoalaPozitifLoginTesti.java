package tests.day16;

import org.testng.annotations.Test;

import pages.KoalaResortPage;
import utilities.Driver;
import utilities.TestBase;

public class C2_KoalaPozitifLoginTesti  {

    /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
            http://qa-environment.koalaresorthotels.com adresine git
            login butonuna bas
        test data username: manager ,
        test data password : Manager1!
        Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

     */

    @Test
    public void pozitifLoginTesi(){
        Driver.getDriver().get("http://qa-environment.koalaresorthotels.com");

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys("manager");
        koalaResortPage.passwordTexBox.sendKeys("Manager1!");
        koalaResortPage.loginButonu.click();

    }
}
