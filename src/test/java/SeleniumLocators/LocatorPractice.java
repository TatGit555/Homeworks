package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        // SET UP WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        //TASK
       /* 1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
        2-Enter first and last name (textbox).
        3-Select gender (radio button).
        4-Select years of experience (radio button).
        5-Enter date.(send keys)
        6-Select Profession (Checkbox). -->choose Both
        7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
        8-Select Continent(Send Keys).
        9-Click on Submit button.
        10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
        10-Close the webpage
        Try your own logic and automate it without any help.
     */
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //1.
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        //2.
        WebElement name = driver.findElement(By.name("firstname"));
        Thread.sleep(2000);
        name.sendKeys("Tatiana");//vpisat name
        WebElement lastname = driver.findElement(By.name("lastname"));
        Thread.sleep(2000);
        lastname.sendKeys("R");//vpisat name
        //3.
        WebElement gender = driver.findElement(By.id("sex-1"));//choose female
        Thread.sleep(2000);
        gender.click();//press button

        //4.
        WebElement years = driver.findElement(By.id("exp-5"));
        Thread.sleep(2000);
        years.click();
        //5.
        WebElement date = driver.findElement(By.id("datepicker"));
        Thread.sleep(2000);
        date.sendKeys("5/16/2023");

        //6.
        WebElement profession = driver.findElement(By.id("profession-1"));
        Thread.sleep(2000);
        profession.click();
        //7.
        WebElement tools = driver.findElement(By.id("tool-2"));
        Thread.sleep(2000);
        tools.click();
        //8.
        WebElement continent =  driver.findElement(By.name("continents"));
        Thread.sleep(2000);
        continent.sendKeys("North America");

        //9.
        WebElement button = driver.findElement(By.id("submit"));
        Thread.sleep(2000);
        button.click();

        //10.1
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualURL.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");

        //10.2
        Thread.sleep(2000);
        driver.quit();





    }
}
