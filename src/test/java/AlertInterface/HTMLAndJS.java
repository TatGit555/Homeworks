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

public class HTMLAndJS {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");

        WebElement preview1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview1.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Oops, something went wrong!");
        alert.accept();

        WebElement preview2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();

        WebElement message = driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(BrowserUtils.getText(message));//will print with ok

        WebElement button = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        button.click();

        driver.quit();



    }
}
