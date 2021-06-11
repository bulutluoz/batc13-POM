package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoalaResortLoginPage {

    // 1- Webdriver olustur
    WebDriver driver;

    // 2- parametreli bir public constructor olustur
    // ve parametre olarak Webdriver driver yaz

    public KoalaResortLoginPage(WebDriver driver){

        // 3- parametre olarak gelen driver ile bu class'daki driver'i eslestir
        this.driver=driver;

        // 4- PageFactory class'ini kullanarak driver'i initialize yap

        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;


    @FindBy(id = "Password")
    public WebElement passwordTexBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;
}
