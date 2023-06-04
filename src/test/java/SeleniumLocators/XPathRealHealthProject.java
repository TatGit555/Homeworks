package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    public static void main(String[] args) throws InterruptedException {

         /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment  -- done
3-Login the username and password provided and Login successfully --done
4-Choose the facility either HongKong or Seoul -->send keys --done
5-Click apply for hospital admission box if it is displayed and validate it is selected --done
6-Healthcare program 'Medicaid'  -- done
7-Visit date should be provided -->send keys --done
8-Put your comment for this box -->send keys --done
9-Book your appointment --done
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement) --done
11-Print out the headers and values(only values) on your console. --done
12-Click go to homepage and print out url--done
13-Driver.quit or close.--done

           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/ ");

        //CSS selector WITH ID
        //WebElement appointment = driver.findElement(By.xpath("//a[contains(text(),'Appointment')]"));
        WebElement appointment = driver.findElement(By.cssSelector("#btn-make-appointment")); //CSS WITh ID by hash
        Thread.sleep(2000);
        appointment.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        Thread.sleep(2000);
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        Thread.sleep(2000);
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        Thread.sleep(2000);
        login.click();


        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        Thread.sleep(2000);
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement apply = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (apply.isDisplayed() && ! apply.isSelected()){
            Thread.sleep(2000);
            apply.click();
        }

        WebElement program = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        Thread.sleep(2000);
        program.click();
        WebElement date = driver.findElement(By.xpath("//input[@name='visit_date']"));
        Thread.sleep(2000);
        date.sendKeys( "07/06/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@name='comment']"));
        Thread.sleep(2000);
        comment.sendKeys("Appointment with Dr.House");

        //CSS selector WITH ID
        //WebElement book = driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement book = driver.findElement(By.cssSelector(".btn-default"));//css with class
        Thread.sleep(2000);
        book.click();

        WebElement confirmation = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualheader = confirmation.getText().trim();
        String expectedheader = "Appointment Confirmation";
        System.out.println(actualheader.equals(expectedheader) ? "Appointment Confirmed" : "FAILED");

        WebElement header1 = driver.findElement(By.xpath("//p[contains(text(),'CURA')]"));
        System.out.println(header1.getText());

        WebElement header2 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(header2.getText());

        WebElement header3 = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(header3.getText());

        WebElement header4 = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(header4.getText());

        WebElement header5 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(header5.getText());

        WebElement goToHomePage =driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        Thread.sleep(2000);
        goToHomePage.click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();














    }
}
