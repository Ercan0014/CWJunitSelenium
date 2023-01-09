package SeleniumOdev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class AmazonTest extends BaseTest {


    /*
    o https://www.amazon.com.tr/ sitesi açılır.
    o Ana sayfanın açıldığı kontrol edilir.
    o Çerez tercihlerinden Çerezleri kabul et seçilir.
    o Siteye login olunur.
    o Login işlemi kontrol edilir.
    o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    o Bilgisayar kategorisi seçildiği kontrol edilir.
    o Arama alanına MSI yazılır ve arama yapılır.
    o Arama yapıldığı kontrol edilir.
    o Arama sonuçları sayfasından 2. sayfa açılır.
    o 2. sayfanın açıldığı kontrol edilir.
    o Sayfadaki 2. ürün favorilere eklenir.
            o 2. Ürünün favorilere eklendiği kontrol edilir.
    o Hesabım > Favori Listem sayfasına gidilir.
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        // Ana sayfanın açıldığı kontrol edilir.
        WebElement anasayfaKontrol= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(anasayfaKontrol.isDisplayed());
        //  String currentURL = driver.getCurrentUrl();
        //  Assert.assertTrue("url amazon içermiyor", currentURL.contains("amazon"));

        // Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cerezleriKabul= driver.findElement(By.id("sp-cc-accept"));
        cerezleriKabul.click();

        // Siteye login olunur.
        Actions action=new Actions(driver);

        WebElement login=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        login.click();

        WebElement emailyazma=driver.findElement(By.xpath("//input[@id='ap_email']"));
        emailyazma.sendKeys("45gereksiz@gmail.com"+ Keys.ENTER);

        WebElement sifreyazma=driver.findElement(By.xpath("//input[@id='ap_password']"));
        sifreyazma.sendKeys("Ders4545"+Keys.ENTER);
        //WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        //String mail = "45gereksiz@gmail.com";

        //String mailPassword = "Ders4545";

        //emailInput.sendKeys(mail + Keys.ENTER);

        //Actions actions = new Actions(driver);

        //actions.sendKeys(mailPassword).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

//        o Login işlemi kontrol edilir.
        WebElement logincontrol=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        action.moveToElement(logincontrol).perform();

        // Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement searchDropDownBox = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        searchDropDownBox.click();

        Select select= new Select(searchDropDownBox);
        select.selectByValue("search-alias=computers");

//    Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertTrue(searchDropDownBox.getText().contains("Bilgisayarlar"));

        // Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("MSI" + Keys.ENTER);

        // Arama yapıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-normal']")).isDisplayed());
        // o Arama yapıldığı kontrol edilir.
        //  WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
