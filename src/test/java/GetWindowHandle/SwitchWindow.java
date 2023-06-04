package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement click = driver.findElement(By.xpath("//a[.='Click Here']"));
        click.sendKeys(Keys.ENTER);
        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));//"Opening a new window"

        System.out.println(driver.getWindowHandle());//returns id of the page, main page id DD54090D806DBD203DA302DACBFF784A The Internet
        driver.getWindowHandles();
        Set<String> allPagesId = driver.getWindowHandles();
        System.out.println(allPagesId);//[E30E8967577D63C8BC37121F202D14C9, E4A5BC064650C62C7319F26F64C39372]
        String mainPageId = driver.getWindowHandle();

        for(String id: allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
            System.out.println(driver.getWindowHandle());//will print out the current one
        }

        message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));
    }

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement clickButton = driver.findElement(By.cssSelector("#newTabBtn"));
        clickButton.click();

        String mainPageId= driver.getWindowHandle(); //current
        Set<String> allPagesId = driver.getWindowHandles();

        for(String id : allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }

        String actualTitle = driver.getTitle().trim();
        String expTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expTitle);

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Demo')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader,expHeader);

        WebElement click2Button = driver.findElement(By.cssSelector("#confirmBox"));
        Thread.sleep(1000);
        click2Button.click();








    }
}
