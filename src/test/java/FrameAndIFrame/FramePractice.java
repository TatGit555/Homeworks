package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FramePractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));//An iFrame containing the TinyMCE WYSIWYG Editor

        driver.switchTo().frame("mce_0_ifr");// makes happen to write in protected frame
        WebElement iLoveSelenium = driver.findElement(By.cssSelector("#tinymce"));
        iLoveSelenium.clear();
        iLoveSelenium.sendKeys("I love Selenium");//doesn't work

        driver.switchTo().parentFrame(); //goes one before
        message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));//first was stale element not found because now the message is inside the frame
    }

        @Test
                public void practice2() throws InterruptedException {
            /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Python" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://skpatro.github.io/demo/iframes/");

            WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
            Thread.sleep(300);
            pavilion.click();

            //go to another tab
            BrowserUtils.switchByTitle(driver, "Home");

            WebElement selenium = driver.findElement(By.linkText("Selenium"));
            Actions actions = new Actions(driver);
            actions.moveToElement(selenium).perform();

            Thread.sleep(300);
            WebElement selPyton = driver.findElement(By.linkText("Selenium-Python"));
            selPyton.click();

            //validate the header
            WebElement header = driver.findElement(By.tagName("h1"));
            String actualHeader = BrowserUtils.getText(header);
            String expectedHeader = "Selenium-Python Tutorial";
            Assert.assertEquals(actualHeader, expectedHeader);

            //printout all the links
            List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));//parent p , child a
            for (WebElement link : allLinks) {
                System.out.println(BrowserUtils.getText(link));
            }
            Thread.sleep(1000);

            //go to another tab
            BrowserUtils.switchByTitle(driver, "iframes");

            driver.switchTo().frame("Framename1");

            WebElement category = driver.findElement(By.xpath("//a[.='Category1']"));
            Thread.sleep(300);
            category.click();

            BrowserUtils.switchByTitle(driver, "testing");

            WebElement headerCategory = driver.findElement(By.xpath("//h1"));
            String actualheader = BrowserUtils.getText(headerCategory);
            String expheader = "Category Archives: SeleniumTesting";
            Assert.assertEquals(actualheader,expheader);
            Thread.sleep(1000);

            List<WebElement> headers = driver.findElements(By.xpath("//h3[@class='entry-title']"));
            for(WebElement eachheader : headers){
                System.out.println("======" + BrowserUtils.getText(eachheader));
            }

            /*
TASK 3:
1-Go back mainPage
2-print out I am inside Frame under category1
3-Click Category3
4-Print out the header
 */

            BrowserUtils.switchByTitle(driver, "iframes");
            driver.switchTo().frame("Framename1");
            WebElement inframe=driver.findElement(By.cssSelector("#frametext"));
            System.out.println(BrowserUtils.getText(inframe));

            driver.switchTo().frame("Frame2");
            WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
            category3.click();

            driver.switchTo().parentFrame();
            BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

            WebElement header3= driver.findElement(By.xpath("//h1"));
            System.out.println(header3.getText());

            driver.quit();
        }

        }




