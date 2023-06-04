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

public class AlertPractice {
    @Test
    public void practiceJSAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        WebElement alertMsg = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(alertMsg),"You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        //Alert alert1 = driver.switchTo().alert(); sometimes needed to reassign
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.dismiss();
        WebElement confirmMsg = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(confirmMsg),"You pressed Cancel in confirmation popup");

        WebElement promPtBox = driver.findElement(By.cssSelector("#promptBox"));
        promPtBox.click();

        alert.sendKeys("Tania");
        alert.accept();
        WebElement promptMsg = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(promptMsg),"You entered text Tania in propmt popup");


    }
}
