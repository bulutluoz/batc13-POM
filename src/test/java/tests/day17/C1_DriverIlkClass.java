package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C1_DriverIlkClass {

    @Test
    public void test01(){

        Driver.getDriver().get("https://youtube.com");
        // eskiden kullandigimiz driver yerine Driver.getDriver() bunu kullanacagiz

        Driver.getDriver().get("https://facebook.com");

        Driver.getDriver().get("https://amazon.com");

        Driver.closeDriver();

    }
}
