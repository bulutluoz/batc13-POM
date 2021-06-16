package tests.day16;

import org.testng.annotations.Test;

import pages.KoalaResortPage;
import utilities.Driver;
import utilities.TestBase;

public class C3_KoalaNegatifTest  {

    @Test
    public void negatifTest(){

        Driver.getDriver().get("http://qa-environment.koalaresorthotels.com ");

        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys("manager1");
        koalaResortPage.passwordTexBox.sendKeys("manager1!");
        koalaResortPage.loginButonu.click();

        Driver.closeDriver();

    }
}
