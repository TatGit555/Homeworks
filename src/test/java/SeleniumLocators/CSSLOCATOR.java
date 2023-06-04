package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.SocketHandler;

public class CSSLOCATOR {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://etsy.com/ ");

        WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("watch");
        WebElement button = driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        button.click();

        String actual =driver.getCurrentUrl();
        String expected = "https://www.etsy.com/search?q=watch&ref=search_bar";
        System.out.println(actual.equals(expected) ? "PASSED" : "FAILED");









    }
}
