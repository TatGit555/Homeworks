package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // make slower to wait for more efficient testing
        driver.get("file:///C:/Users/12247/Desktop/Techtorial.html ");

        List<WebElement> allboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));//PLURAL! elementS

        for (WebElement box : allboxes){
            if(box.isDisplayed()&& box.isEnabled()&&!box.isSelected()){
                Thread.sleep(2000);
                box.click();
            }
        }













    }
}
