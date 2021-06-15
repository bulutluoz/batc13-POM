package tests.day18;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C3_WebTableHomework2 {

    @Test
    public void printDataTest(){

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.koalaResortLogin();
        int istenenSatir=Integer.parseInt(ConfigReader.getProperty("webTableRowNo"));
        int istenenSutun=Integer.parseInt(ConfigReader.getProperty("webTableColumnNo"));

        String istenenDataOkunan=koalaResortPage.dataBul(istenenSatir,istenenSutun).getText();
        Assert.assertEquals(ConfigReader.getProperty("webTableExpectedData"),istenenDataOkunan);

        Driver.closeDriver();

    }
}
