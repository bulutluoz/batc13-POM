package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_CreateHotelRoom {

    @Test
    public void createHotelRoomtest() throws InterruptedException {
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));

        //test data password : Manager1!

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        koalaResortPage.loginButonu.click();

        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelRooms.click();
        koalaResortPage.addHotelRoom.click();


        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Select select=new Select(koalaResortPage.idHotelDropdown);
        select.selectByIndex(Integer.parseInt(ConfigReader.getProperty("kr_hotel_room_index")));

        Actions actions=new Actions(Driver.getDriver());

        actions.click(koalaResortPage.codeTextBox)
                .sendKeys(ConfigReader.getProperty("kr_code"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_room_type"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_location"))
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        koalaResortPage.roomTextBox.sendKeys(ConfigReader.getProperty("kr_room_text"));
        actions.
                dragAndDrop(koalaResortPage.fiyatBesYuzButonu,koalaResortPage.priceTextBox).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Select select1=new Select(koalaResortPage.roomTypeDropdown);
        select1.selectByVisibleText(ConfigReader.getProperty("kr_room_type_creation"));

        koalaResortPage.maxAdultCount.sendKeys(ConfigReader.getProperty("kr_adult_count"));
        koalaResortPage.maxChildCount.sendKeys(ConfigReader.getProperty("kr_child_count"));
        // 8. Save butonuna basin.
        koalaResortPage.saveButonu.click();
        Thread.sleep(10000);

        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.

        Assert.assertTrue(koalaResortPage.roomCreatedElementi.isDisplayed());

        //10. OK butonuna tıklayın.
        koalaResortPage.roomCreateSonOK.click();

        //11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();
        koalaResortPage.hotelRooms.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..

        Assert.assertTrue(koalaResortPage.hotelRoomListYaziElementi.isDisplayed());

    }
}
