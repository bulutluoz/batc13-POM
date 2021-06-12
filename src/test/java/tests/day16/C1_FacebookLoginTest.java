package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import pages.FaceBookLoginPage;
import utilities.TestBase;

public class C1_FacebookLoginTest extends TestBase {

    @Test
    public void gelenekselTest(){
        driver.get("https://facebook.com");

        WebElement emailTextBox=driver.findElement(By.id("email"));
        emailTextBox.sendKeys("mehmet@gmail.com");

        WebElement passwordTextBox=driver.findElement(By.id("pass"));
        passwordTextBox.sendKeys("12345");

        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test
    public void pageIleTest(){
        driver.get("https://facebook.com");

        FaceBookLoginPage faceBookLoginPage=new FaceBookLoginPage(driver);


        faceBookLoginPage.emailTextBox.sendKeys("mehmet@gmail.com");
        faceBookLoginPage.passwordTexBox.sendKeys("12345");
        faceBookLoginPage.loginButonu.click();


    }
}
