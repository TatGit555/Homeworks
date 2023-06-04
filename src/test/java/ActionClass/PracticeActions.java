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

public class PracticeActions {
    @Test
    public void dragAndDropPractice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dragger = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(dropBox);
        String expectedMessage = "Drop here";
        Assert.assertEquals(actualMessage, expectedMessage);

        //pick up dragger and drop to the box
        dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragger, dropBox).perform();

        //color
        String actualbg = dropBox.getCssValue("background-color");//poluchit color from the system
        String expectedbg = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualbg, expectedbg);
    }

        @Test
        public void clickAndHoldPractice2() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/droppable");

            //click accept
            //validate not acceptable, validate drop here
            //click and hold not acceptable and move to drop

            WebElement accept = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
            accept.click();

            WebElement notAcceptButton = driver.findElement(By.cssSelector("#notAcceptable"));
            Thread.sleep(1000);
            String actual = BrowserUtils.getText(notAcceptButton);
            String expected = "Not Acceptable";
            Assert.assertEquals(actual,expected);

            WebElement dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));////div[id@='simpleDropContainer'//div[id@='droppable']
            Actions actions = new Actions(driver);

            Thread.sleep(3000);
            actions.clickAndHold(notAcceptButton).moveToElement(dropBox).release().perform();








    }
}
