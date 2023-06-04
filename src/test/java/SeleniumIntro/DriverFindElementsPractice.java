package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // make slower to wait for more efficient testing
        driver.get("https://the-internet.herokuapp.com/");


        List<WebElement> links = driver.findElements(By.tagName("li"));
        int count = 0;
        for (WebElement link : links){

            if(link.getText().length() >=12){  // find long names of sites and printout only them
                System.out.println(link.getText());
                count++;
            }
        }
        System.out.println("Links total: " + count);// or links.size(); 44 total, 31 long





    }
}
