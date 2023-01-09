package SeleniumOdev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class C02_Odev extends BaseTest {

    @Test
    public void selectMethod(){
        driver.get("https://demoqa.com/select-menu");
        WebElement selectButton= driver.findElement(By.id("oldSelectMenu"));
        Select secim=new Select(selectButton);
        System.out.println(secim.isMultiple());
        secim.selectByIndex(3);
        secim.selectByValue("4");
        secim.selectByVisibleText("Black");



    }
}
