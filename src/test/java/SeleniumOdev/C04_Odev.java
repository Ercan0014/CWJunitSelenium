package SeleniumOdev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class C04_Odev extends BaseTest {



    @Test
    public void Test() {


// - https://demoqa.com/select-menu sitesine gidin
        driver.get("https://demoqa.com/select-menu");

//- multiple <select> elementini locate edin
        WebElement selectButton=driver.findElement(By.id("cars"));


     //   Birden fazla secim yapip secimlerinizi DOGRULAyin

        Select option = new Select(selectButton);
        System.out.println(option.isMultiple());
        option.selectByVisibleText("Volvo");
        option.selectByIndex(1);
        option.selectByVisibleText("Opel");
        option.selectByIndex(3);
        Assert.assertTrue(!selectButton.isSelected());
    }
}
