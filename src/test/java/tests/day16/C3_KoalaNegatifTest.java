package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.TestBase;

public class C3_KoalaNegatifTest extends TestBase {

    @Test
    public void negatifTest(){

        driver.get("http://qa-environment.koalaresorthotels.com ");

        KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);

        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.kullaniciAdiTextBox.sendKeys("manager1");
        koalaResortLoginPage.passwordTexBox.sendKeys("manager1!");
        koalaResortLoginPage.loginButonu.click();

    }
}
