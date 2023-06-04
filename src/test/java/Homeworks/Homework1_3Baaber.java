package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1_3Baaber {
    public static void main(String[] args) throws InterruptedException {


//Steps
//SELENIUM-1 CODEFISH
//Test Case 3 Navigate to "https://www.saucedemo.com/"
//Enter username "standard_user"
//Enter password "secret_sauce"
//Click Login button
//Validate current url is //"https://www.saucedemo.com/inventory.html"



        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement name = driver.findElement(By.xpath("//input[@id='user-name']"));
        Thread.sleep(2000);
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        Thread.sleep(2000);
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(2000);
        login.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
