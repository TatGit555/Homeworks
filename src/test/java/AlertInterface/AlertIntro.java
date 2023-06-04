package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void acceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickJS = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        clickJS.click();

        Alert alert = driver.switchTo().alert();
        String actual = alert.getText().trim();//I can not inspect by myself
        String expected = "I am a JS Alert";
        Assert.assertEquals(actual, expected);

        //click popup
        //we didn't click and got UnhandledAlertException, it means ignored popup
        alert.accept(); //click OK button

        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement confirmJS = driver.findElement(By.xpath("//button[contains(@onclick,'Confirm')]"));
        confirmJS.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss(); //click CANCEL button

        WebElement prompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        Thread.sleep(2000);
        prompt.click();

        Thread.sleep(2000);
        alert.sendKeys("Homework is Important");
        Thread.sleep(2000);
        alert.accept();

        WebElement message = driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You entered: Homework is Important";
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}