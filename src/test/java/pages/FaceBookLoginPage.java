package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage {
    WebDriver driver;

    public FaceBookLoginPage(WebDriver driver) {
    }


    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(id="pass")
    public WebElement passwordTexBox;

    @FindBy(xpath="//button[@name='login']")
    public WebElement loginButonu;
}

