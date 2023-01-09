package Deneme;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C01 extends BaseTest {


   @Test
    public void test(){
       driver.get("https://www.amazon.com");
       WebElement cerez=driver.findElement(By.xpath("//input[@id=\"sp-cc-accept\"]"));
        cerez.click();

        WebElement secim =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

   }


}
