package SeleniumOdev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C05_Odev extends BaseTest {


//- https://demoqa.com/select-menu sitesine gidin
//- multiple <select> elementini locate edin
//- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
//* Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin

    @Test
    public void test(){
        // Go to URL: http://demo.guru99.com/test/guru99home/
       driver.get("http://demo.guru99.com/test/guru99home/");

      // Find the number of iframes on the page.
List<WebElement> linklist =driver.findElements(By.xpath("//iframe"));
        System.out.println(linklist.size());
      // Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.

        // Exit the iframe and return to the main page.
    }
}
