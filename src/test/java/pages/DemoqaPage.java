package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {

   public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='rt-resizable-header-content']")
    public List<WebElement> headerList;

   @FindBy(xpath = "//div[@class='rt-table']")
    public WebElement tumBodyElementi;

   @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement> tumHucrelerListesi;

   @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> satirlarListesi;



   public void sutunYazdir(int sutunNo){


       for (int i=1; i<=satirlarListesi.size();i++){
           WebElement element =Driver.getDriver().findElement(By.xpath("((//div[@class='rt-tr-group'])[" +sutunNo+ "]//div//div)[3]"));
           System.out.println(element.getText());
       }
   }

   public void istenenKisininMaasiniYazdir(String isim){
       int salaryninSutunNumarasi = 0;

       for (int i = 1; i < headerList.size(); i++) {

           if (headerList.get(i).getText().equals("Salary")) {
               salaryninSutunNumarasi = i;
           }
       }
       salaryninSutunNumarasi++;
       System.out.println("Salarynin sutun numarasi = " + salaryninSutunNumarasi);

       int istenenKisiSatirSayisi=0;
       for (int i=1;i<satirlarListesi.size();i++){
           // ((//div[@class='rt-tr-group'])[1]//div//div)[1]  1.satirin 1.kolonu

           String elementYolu = "((//div[@class='rt-tr-group'])["+i+"]//div//div)[1]";

           WebElement element = Driver.getDriver().findElement(By.xpath(elementYolu));

           if (element.getText().equals(isim)){
               istenenKisiSatirSayisi=i;
           }

       }

       System.out.println("Istenen isim satir Sayisi = " + istenenKisiSatirSayisi);
       String arananSalaryXpath="((//div[@class='rt-tr-group'])["+istenenKisiSatirSayisi+"]//div//div)["+salaryninSutunNumarasi+"] ";
       WebElement arananSalary=Driver.getDriver().findElement(By.xpath(arananSalaryXpath));
       System.out.println("Istenen kisinin Salary'si : " + arananSalary.getText());
   }

   public void istenenHucreYazdir(int satirNo, int sutunNo){

       int dataNo= (satirNo-1)*7 + sutunNo;


       WebElement data=Driver.getDriver().findElement(By.xpath("(//div[@class='rt-td'])["+dataNo+"]"));

       System.out.println("istenen data : " + data.getText());


   }

}
