package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealLifeExamplePractice {
    public static void main(String[] args) {
        //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.godaddy.com/"); //url
        System.out.println(driver.getTitle()); // to validate the site is right

        //method getTitle
        String actualTitle = driver.getTitle();//comes from system
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";// ctrl+F --> //title-->the one I saw, expected
        System.out.println(actualTitle.equals(expectedTitle) ? "Passed Title" : "Failed Title");
                        //comparing if actual == expected//in real life from documentary

        // method getCurrentUrl
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed Url":"Failed Url");

        //method close()
        driver.close();
    }
}
