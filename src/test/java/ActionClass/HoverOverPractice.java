package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class HoverOverPractice {
    @Test
    public void hoverOverPractice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Actions actions = new Actions(driver);

        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            Thread.sleep(500);
            actions.moveToElement(allImages.get(i)).scrollByAmount(200,200).perform();
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(map);







    }

    }
