package JavaScript;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void PracticeJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.click(yesButton).perform();

        WebElement impButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        Thread.sleep(1000);
        actions.click(impButton).perform();

        //click by JS
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click(),impButton");

        WebElement impressive = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actual = BrowserUtils.getText(impressive);
        String expected = "You have selected Impressive";
        Assert.assertEquals(actual, expected);

        WebElement noButton = driver.findElement(By.xpath("//input[@id='noRadio']"));
        Assert.assertFalse(noButton.isEnabled());
    }

        @Test
                public void ScrollIntoView() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://techtorialacademy.com/");

            WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));

            //scrolling the page by JS, most usable by js
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)", findOutCourse);

            Thread.sleep(2000);
            findOutCourse.click();

            WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
            BrowserUtils.scrollWithJS(driver,copyRight);//vedet down to this word

            String actual = BrowserUtils.getText(copyRight);
            String expected = "Copyright © 2023";
            Assert.assertEquals(actual,expected);

            Thread.sleep(1000);
            WebElement apply = driver.findElement(By.linkText("Apply Now"));
            BrowserUtils.scrollWithJS(driver,apply);
            BrowserUtils.clickWithJS(driver,apply);

            Thread.sleep(1000);
            String actTitle = BrowserUtils.getTitleWithJS(driver);
            String expTitle = "Apply Now";
            Assert.assertEquals(actTitle,expTitle);

            List<WebElement> allInfo = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
            List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

            for(int i = 0; i< allInfo.size(); i++){
                Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)), expectedInfo.get(i));
            }






        }

    }

