package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C1_windowHandleWithReusableMethods {

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        // Elemental Selenium yazisina tiklayalim
        // acilan windows'da Sponsored by Sauce Labs yazisi locate edip yazdirin

        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // ben click yapmadan var olan window'un handle'ni alsam
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();

        ReusableMethods.waitFor(10);  // throw'a gerek kalmadan yazilan saniye kadar kodu bekletir

        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();


        // Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro

        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");

        /* eskiden kullandigimiz kod

        // click yaptiktan sonra tum handle degerlerini alsam
        Set<String> handleListesi = Driver.getDriver().getWindowHandles();

        // elimizde icinde 2 handle degeri bulunan bir set var
        // Bunlardan biri ilk sayfanin handle degeri
        // ikinci sayfanin handle degerini nasil bulabilirim

        String ikinciSayfaHandleDegeri="";

        for (String each: handleListesi
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }

        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());
        */

        WebElement souceLabYazisiElementi=Driver.getDriver().findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(souceLabYazisiElementi.getText());


    }

}
