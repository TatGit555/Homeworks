package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void dragAndDropMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        //validate message in a box
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);

        //validate of color
        String actualbackGroundColor = orangeBox.getCssValue("background-color");
        String expectedBGColor = "rgba(238, 111, 11, 1)"; //go to pick up HEX #ee6f0b; and then online get the RGB
        Assert.assertEquals(actualbackGroundColor, expectedBGColor);

        //find location of dragger
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragger, orangeBox).perform(); //source is circle, target is orange box, then drag and perform

        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));//follow the instructions from sublime, kind of reassign
        String actualDD = BrowserUtils.getText(orangeBox);
        String expectedDD = "You did great!";
        Assert.assertEquals(actualDD, expectedDD);
    }

        @Test
                public void dragAndDropPractice1() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

            WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
            String actualMessage = BrowserUtils.getText(blueBox);
            String expectedMessage = "Drag the small circle here ...";
            Assert.assertEquals(actualMessage, expectedMessage);

            //validate of color
            String actualbg = blueBox.getCssValue("background-color");
            String expectedbg = "rgba(63, 81, 181, 1)"; //go to pick up HEX; and then online or get exception get the RGB
            Assert.assertEquals(actualbg, expectedbg);

            WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(dragger, blueBox).perform();//option1

            Thread.sleep(1000);
            blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
            actions.clickAndHold(dragger).moveToElement(blueBox).release().perform(); //взять,зажать,перетащить,отпустить

        }






    }

