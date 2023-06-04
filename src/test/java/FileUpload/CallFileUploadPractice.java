package FileUpload;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CallFileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\12247\\Desktop\\CodeFish\\usa_720.png");
        WebElement button = driver.findElement(By.cssSelector(".button"));
        button.submit();
        //button.click() -- almost the same but there is a difference
        WebElement file = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(BrowserUtils.getText(file).contains("usa_720"));
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFile.sendKeys("C:\\Users\\12247\\Desktop\\CodeFish\\usa_720.png");
        WebElement acceptButton = driver.findElement(By.xpath("//input[@id='terms']"));

        if (acceptButton.isDisplayed() && acceptButton.isSelected() && acceptButton.isEnabled()) {
            acceptButton.click();
        }

        WebElement submitButton = driver.findElement(By.cssSelector("#submitbutton"));
        submitButton.submit();
        WebElement message = driver.findElement(By.xpath("//b[.='Select file to send(max 196.45 MB)']"));
        Assert.assertEquals(BrowserUtils.getText(message),"Select file to send(max 196.45 MB)");
        WebElement validate = driver.findElement(By.tagName("h3"));
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(validate),"1 file\n" + "has been successfully uploaded.");

    }
}
