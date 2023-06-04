package JavaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void getTitle() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");

        System.out.println(driver.getTitle() + " with regular Selenium Method");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title") + " with JavaScript");
    }

        @Test
                public void clickJS() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://codefish.io/");

            //1st
            WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
            Actions actions = new Actions(driver);
            actions.click().perform();
            Thread.sleep(1000);
            //2nd
            driver.navigate().back();
            aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
            aboutUs.click();
            Thread.sleep(1000);
            //3rd
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()");








        }






    }

