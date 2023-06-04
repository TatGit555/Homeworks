package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeArrowDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("ocean drive");

        WebElement searchBtn = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        Thread.sleep(1500);
        searchBtn.click();
        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song : songs) {
            song.sendKeys((Keys.ARROW_DOWN)); //scrolling down
            if (song.getAttribute("title").contains("Ocean Drive")) {    //or equals the exact name
                Thread.sleep(3000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();

            }
        }
    }
}
