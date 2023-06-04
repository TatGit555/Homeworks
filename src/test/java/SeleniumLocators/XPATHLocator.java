package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com");

        //find unique element by (contains A/B), then click
        WebElement abTesting = driver.findElement(By.xpath ("//a[contains(text(),'A/B')]"));
        abTesting.click();

        //find and print out header by Absolute XPath
        WebElement header = driver.findElement(By.xpath("html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        //find and print out paragraph by Absolute XPath
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

        //find element selenium and click
        WebElement selenium = driver.findElement(By.xpath ("//a[contains(text(),'Selenium')]"));
        selenium.click();




    }
}
