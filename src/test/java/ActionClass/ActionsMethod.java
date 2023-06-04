package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethod {

    @Test //right click
    public void contextClick() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.xpath("//id[.='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform(); //to make right click, don't forget perform
    }


        @Test
        public void rightClickMethod() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.guru99.com/test/simple_context_menu.html");

            WebElement rightClick = driver.findElement(By.xpath("span[.context-menu-one]"));
            Actions actions = new Actions(driver);
            actions.contextClick(rightClick).perform();
        }

            @Test
            public void doubleClickMethod(){
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriver driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get("https://demo.guru99.com/test/simple_context_menu.html");

                WebElement button = driver.findElement(By.tagName("button"));
                Actions actions = new Actions(driver);
                actions.doubleClick(button).perform();

            }

        }






