package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        //for the next 2 months
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        //set up driver
        ChromeDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/12247/Desktop/Techtorial.html");

        //LINKTEXT LOCATOR: <a href ...link > TEXT TO NAME </a> in html

        WebElement javalink = driver.findElement(By.linkText("Java"));//copy just TEXT, no link
        javalink.click();

        WebElement javaheader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaheader.getText().trim();
        String expectedHeader = "Java";
        System.out.println( actualHeader.equals(expectedHeader) ? "JavaHeader Correct" : "Fail");//JavaHeader Correct

        //finding Selenium
        driver.navigate().back();
        WebElement selLink = driver.findElement(By.linkText("Selenium"));
        selLink.click();

        WebElement selHeader = driver.findElement(By.tagName("h1"));
        String actualSelHeader = selHeader.getText().trim();
        String expSelHeader = "Selenium automates browsers. That's it!";
        System.out.println(selHeader.getText());
        System.out.println( actualSelHeader.equals(expSelHeader) ? "Selenium Header Correct" : "Fail");
        driver.navigate().back();

        // checking cucumber

        WebElement cucLink = driver.findElement(By.linkText("Cucumber"));
        cucLink.click();

        WebElement cucHeader = driver.findElement(By.tagName("h1"));
        String actualcucHeader = cucHeader.getText().trim();
        String expcucHeader = "Tools & techniques that elevate teams to greatness";
        System.out.println(cucHeader.getText());
        System.out.println( actualcucHeader.equals(expcucHeader) ? "Cucumber Header Correct" : "Fail");
        Thread.sleep(2000);
        driver.navigate().back();

        //check TestNG
        WebElement testnglink = driver.findElement(By.linkText("TestNG"));
        testnglink.click();

        WebElement testHeader = driver.findElement(By.tagName("h2"));// there are 2 h2. 50% success, what to pass
        System.out.println(testHeader.getText());
        //validate with ternary
        driver.navigate().back();
        String actual = driver. getCurrentUrl();
        String expected =  "file:///C:/Users/12247/Desktop/Techtorial.html";
        System.out.println(actual.equals(expected) ? "URL PASSED" : "URL FAILED");


        //LOCATOR PARTIAL LINKTEXT:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());









    }
}
