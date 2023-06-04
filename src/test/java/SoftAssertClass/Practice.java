package SoftAssertClass;

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
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {
    @Test
    public void practice() throws InterruptedException {
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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alert.getText(), "I am an alert box33!");
        alert.accept();

        WebElement alertMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(alertMsg), "You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        //Alert alert1 = driver.switchTo().alert(); sometimes needed to reassign
        softAssert.assertEquals(alert.getText(), "Press a button!");
        alert.dismiss();
        WebElement confirmMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(confirmMsg), "You pressed Cancel in confirmation popup");

        WebElement promPtBox = driver.findElement(By.cssSelector("#promptBox"));
        promPtBox.click();

        alert.sendKeys("Tania");
        alert.accept();
        WebElement promptMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(promptMsg), "You entered text Tania in prompt popup");

        softAssert.assertAll();// for soft but orange result
    }
}
