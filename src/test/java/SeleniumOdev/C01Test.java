package SeleniumOdev;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*
- https://demoqa.com/select-menu sitesine gidin
- multiple <select> elementini locate edin
- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
 */
public class C01Test {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    //- https://demoqa.com/select-menu sitesine gidin

    @Test
    public void test() {
        driver.get("https://demoqa.com/select-menu");

        // - multiple <select> elementini locate edin
        WebElement cars = driver.findElement(By.id("cars"));
        Select select = new Select(cars);

        // - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
        System.out.println("*******Get Options********");

        select.getOptions().stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("*******Get by Index********");

        select.selectByVisibleText("Audi");
        System.out.println("*******Get First Selected Options********");

        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("******** Select By....********");

        select.selectByIndex(0);
        select.selectByVisibleText("Opel");
        select.selectByVisibleText("Audi");

        System.out.println("********Get All Selected********");
        select.getAllSelectedOptions().stream().forEach(t -> System.out.println(t.getText()));
        List<WebElement> tumsecimler = select.getAllSelectedOptions();

        Assert.assertTrue(tumsecimler.get(2).getText().contains("Audi"));

    }
}
