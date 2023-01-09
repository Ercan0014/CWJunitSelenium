package SeleniumOdev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class C02_Test {

   // URL'ye gidin: https:demoqa.combrowser-windows Pencerelere tıklayın -
    // "WindowButton" Tüm alt pencerelere tıklayın.
    // Konsoldaki tüm alt pencerelerde bulunan metni yazdırın.
    // Ana pencerenin başlığını konsolda yazdırın.

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
    public void test() throws InterruptedException {
        // Go to URL: https://demoqa.com/browser-windows

        driver.get("https://demoqa.com/browser-windows");
        // Click on the windows - "WindowButton"
        //Pencerelere tıklayın
        String homepage = driver.getWindowHandle();

        // Click on all the child windows./ Alt pencereleri yazdırın
        //driver.findElement(By.id("\"//button[id='tabButton']\""));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='windowButtonWrapper']"));
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
        Thread.sleep(4000);
        Set<String> windowAll=driver.getWindowHandles();

        // Print the text present on all the child windows in the console.
        // Konsoldaki tüm alt pencerelerde bulunan metni yazdırın.
        Iterator<String>iterator = windowAll.iterator();

        // Print the heading of the parent window in the console.
        //Ana pencerenin başlığını konsolda yazdırın.

        //System.out.println(driver.switchTo().defaultContent().getTitle());
        driver.switchTo().window(homepage);
    }
}