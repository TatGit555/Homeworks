package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;

public class Homework1 {
    public static void main(String[] args) throws InterruptedException {
        //find 3 websites
        //2-Under 1 main method--> go to 3 different websites and validate the title, and URL of the page with Ternary Operator. (It can be any website you decide)
        //SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.kohls.com/");
        System.out.println(driver.getTitle());

        String actualTitle1 = driver.getTitle();//comes from system
        String expectedTitle1 = "Kohl's | Shop Clothing, Shoes, Home, Kitchen, Bedding, Toys & More";
        System.out.println(actualTitle1.equals(expectedTitle1) ? "Passed Kohl's Title" : "Failed Kohl's");
        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl1 = "https://www.kohls.com/";
        System.out.println(actualUrl1.equals(expectedUrl1) ? "Passed Kohl's Url":"Failed Kohl's Url");



        //2nd

        driver.get("https://www.target.com/");
        System.out.println(driver.getTitle());
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Target : Expect More. Pay Less.";
        System.out.println(actualTitle2.equals(expectedTitle2) ? "Passed Target Title" : "Failed Target");
        String actualUrl2 = driver.getCurrentUrl();
        String expectedUrl2 = "https://www.target.com/";
        System.out.println(actualUrl2.equals(expectedUrl2) ? "Passed Target Url":"Failed Target Url");

        //3rd

        driver.get("https://cafezupas.com/");
        System.out.println(driver.getTitle());
        String actualTitle3 = driver.getTitle();//comes from system
        String expectedTitle3 = "Soup, Salad and Sandwich Kitchen & Catering — Café Zupas";// ctrl+F --> //title-->the one I saw, expected
        System.out.println(actualTitle3.equals(expectedTitle3) ? "Passed Zupas Title" : "Failed Zupas");
        String actualUrl3 = driver.getCurrentUrl();
        String expectedUrl3 = "https://cafezupas.com/";
        System.out.println(actualUrl3.equals(expectedUrl3) ? "Passed Zupas Url":"Failed Zupas Url");
        Thread.sleep(2000);
        driver.close();












    }
}
