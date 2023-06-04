package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1_2Baaber {
    public static void main(String[] args) throws InterruptedException {

//Steps

//Test Case 2 Navigate to "https://www.saucedemo.com/"
//Enter username "Java"
//Enter password "Selenium"
//Click Login button

//Validate "Epic sadface: Username and password do not
//match any user in this service" message
//TIPS:to be able to see this message you need to first see this
//message then try to inspect it. (it means at least run one time
//with the username and password you provided above to see
//the message then inspect the message. *be careful with it is fully copied or not.

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement name = driver.findElement(By.xpath("//input[@id='user-name']"));
        Thread.sleep(2000);
        name.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        Thread.sleep(2000);
        password.sendKeys("Selenium");
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(2000);
        login.click();

        WebElement message = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actual = message.getText().trim();
        String expected = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actual.equals(expected) ? "Validation Confirmed" : "Validation Failed");

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();













       Thread.sleep(2000);
       driver.quit();




    }
}
