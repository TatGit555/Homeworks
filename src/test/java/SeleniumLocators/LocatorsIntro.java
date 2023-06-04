package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {

        //Locator is a way to find an element and manipulate it. There are 8 of them.

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        //1.ID LOCATOR:
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("file:///C:/Users/12247/Desktop/Techtorial.html");

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); //gets the text from element//DO NOT FORGET TRIM
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println( actualHeader.equals(expectedHeader) ? "Correct" : "Wrong");

        //print out the paragraph (find by id)
        WebElement header2 = driver.findElement(By.id("details2"));
        System.out.println(header2.getText());

        //To create your account, we'll need some basic information about you.
        // This information will be used to send reservation confirmation emails,
        // mail tickets when needed and contact you if your travel arrangements change.
        // Please fill in the form completely.

        //2. NAME Locator://use only the box! for picking the name, UNIQUE KEYS ONLY
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Tatiana");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Rudinsky");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("2247304434");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("tat.r1812@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("410 Skokie Ct");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Wilmette");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("60091");

        //CLASS LOCATOR:
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());//get

        //check java box validate box functionality
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()){   //box is displayed and NOT selected
           javaBox.click();
        }
        System.out.println(javaBox.isDisplayed() ? "Java selected": "not selected");

        //check cucumber
        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if(cucumberBox.isDisplayed() && !cucumberBox.isSelected()){   //box is displayed and NOT selected
            cucumberBox.click();
        }
        System.out.println(cucumberBox.isDisplayed() ? "Cucumber selected": "not selected");
        //check TestNG
        WebElement testBox = driver.findElement(By.id("cond3"));
        if(testBox.isDisplayed() && !testBox.isSelected()){   //box is displayed and NOT selected
            testBox.click();
        }
        System.out.println(testBox.isDisplayed() ? "TestNG selected": "not selected");

        // TAG NAME LOCATOR:
        WebElement header3 = driver.findElement(By.tagName("u"));
        System.out.println(header3.getText());//Use Java Version
        Thread.sleep(2000);
        driver.quit();








    }
}
