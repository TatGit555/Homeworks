package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {
    public static void main(String[] args) {

        //First Step is setting up your automation

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Then create your Driver to start automation
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/"); //url
        System.out.println(driver.getTitle()); // to validate the site is right

        //method getTitle
        String actualTitle = driver.getTitle();//comes from system
        String expectedTitle = "Amazon.com. Spend less. Smile more.";// the one I saw, expected
        if(actualTitle.equals(expectedTitle)){ //comparing if actual == expected//in real life from documentary
            System.out.println("Passed Title");
        }else{
            System.out.println("Failed Title");
        }

        // method getCurrentUrl
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Passed Url");
        }else {
            System.out.println("Failed Url");
        }

        //method close()
        driver.close();
    }
}
