package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {

        //driver.get
        //driver.manage().window().maximize()
        //driver.navigate.to()
        //driver.navigate.refresh()
        //drive.navigate.back()
        //driver.navigate.forward
        //driver.getPageSource()
        //driver.close()
        //drive.quit()

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //
        driver.navigate().to("https://www.youtube.com/watch?v=QqX1ExNAev0");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        //
        driver.navigate().back(); //back from YouTube to Google
        System.out.println(driver.getTitle()); //title of Google
        driver.navigate().forward(); //back from Google to YouTube
        Thread.sleep(3000);
        System.out.println(driver.getTitle()); //title of YT Frequently Asked Java Program 10: Generate Fibonacci series - YouTube
        driver.navigate().refresh(); //refreshes the page
        Thread.sleep(3000);

        //driver.getPageSource()--> gives the html structure of the page in console
        System.out.println(driver.getPageSource());//not use at all by QA

        //
        driver.quit(); //closes all the pages from one automation

    }
}
