package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1_1Baaber {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement name = driver.findElement(By.xpath("//input[@id='userName']"));
        Thread.sleep(2000);
        name.sendKeys("John Deer");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        Thread.sleep(2000);
        email.sendKeys("jd45689@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        Thread.sleep(2000);
        currentAddress.sendKeys("410 Main str. Chicago, IL");
        WebElement permAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        Thread.sleep(2000);
        permAddress.sendKeys("2184 State str. Chicago, IL");

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        driver.quit();










    }
}
