package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPageId= driver.getWindowHandle(); //main current
        Set<String> allPagesId = driver.getWindowHandles();

        for(String id : allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getTitle().trim());//Courses ( only the last page is printed out!!!)
        BrowserUtils.switchByTitle(driver, "Contact");
        System.out.println(driver.getTitle());//Contact us prints out 2nd tab because of applied method

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver,"course");
        System.out.println(driver.getTitle());//Courses

        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver, "Kick");
        System.out.println(driver.getTitle()); //Kickstart Your Tech Career with Our Top-Rated Coding Bootcamp

    }

    @Test
    public void realTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        // /*
        //1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        //2-Click open multiple tabs under Button 4
        //3-the Basic Control and fill all the blanks
        //4-Click Register button and validate the message "Registration is Successful"
        //5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        //6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        //7-quit all the pages.
        //8-Proud of yourself
        // */

        //1st tab
        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();

        //2nd tab
        BrowserUtils.switchByTitle(driver, "Basic");

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Sobaka");
        Thread.sleep(1000);
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Sobakin");
        Thread.sleep(1000);
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        gender.click();
        Thread.sleep(1000);
        WebElement language = driver.findElement(By.cssSelector("#frenchchbx"));
        language.click();
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("Sobakin@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("sobaka123");
        Thread.sleep(1000);
        WebElement register = driver.findElement(By.cssSelector("#registerbtn"));
        register.click();
        Thread.sleep(1000);

        //validate the message
        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String actualmess = BrowserUtils.getText(message);
        String expmess = "Registration is Successful";
        Assert.assertEquals(actualmess,expmess);

        //1st tab
        BrowserUtils.switchByTitle(driver, "Window Handles");
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualheader = BrowserUtils.getText(header);
        String expheader = "Window Handles Practice";
        Assert.assertEquals(actualmess,expmess);
        Thread.sleep(1000);

        //3rd tab
        BrowserUtils.switchByTitle(driver, "Alert");
        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));
        clickMe.click();
        Thread.sleep(1000);

        driver.quit();




    }
}
