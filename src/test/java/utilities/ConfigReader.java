package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // 1- Properties objesi olusturmak
    //    bu objenin projenin her yerinden Class ismi ile cagrilabilmesi icin static yapiyoruz
    //    bu objeye Class disindan mudahale olmamasi icin private yapiyoruz (opsiyonel)

    static private Properties properties;

    static{
        String path="src/configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();

            // Bu Class calistiginda static block calisacak
            // ve bir tek islem yapacak
            // fileInputStream objesi calisacak ve okudugu bilgileri
            // properties objesine yukleyecek
            properties.load(fileInputStream);


            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){

        String value = properties.getProperty(key);

        return value;
    }

}
