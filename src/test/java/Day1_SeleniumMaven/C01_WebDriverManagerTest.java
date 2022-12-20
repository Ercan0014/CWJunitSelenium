package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {



// Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.

    public static void main(String[] args) {

    // Webdrivermaneger clasini kullanarak chromedriver binary lerimizi indirdik.
        WebDriverManager.chromedriver().setup();

        // driver objemizi oluştrduk.
        WebDriver driver = new ChromeDriver();

            // window u maximize ettik
        driver.manage().window().maximize();

        // google sayfamızı açtık
        driver.get("https://www.google.com");

        //titlemizi aldık
        String title=driver.getTitle();

    // titlemizi doğruladık.
       if(title.equals("Google")){
           System.out.println("test PASSED");
       } else {
           System.out.println("test FAILED");
       }

       // driverimiz kapattık
       driver.quit();

    }

}
