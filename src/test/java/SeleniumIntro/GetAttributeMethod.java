package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttributeMethod {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // make slower to wait for more efficient testing
        driver.get("https://katalon-demo-cura.herokuapp.com/.com/ ");

        WebElement appointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        appointment.click();
        WebElement username = driver.findElement(By.xpath("#input[@value='John Doe']"));
        System.out.println(username.getText());//nothing

        System.out.println(username.getAttribute("value")); // value of the attribute Joe Doe is the value
        System.out.println(username.getAttribute("type")); // text










    }
}
