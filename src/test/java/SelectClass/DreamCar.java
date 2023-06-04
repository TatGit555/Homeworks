package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void validateHeadersOfTheCars() throws InterruptedException {

        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement newCar = driver.findElement(By.name("stock_type"));
        BrowserUtils.selectBy(newCar,"new", "value");

        WebElement make = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");

        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select select = new Select(price);
        String actPrice = BrowserUtils.getText(select.getFirstSelectedOption());
        String expPrice = "No max price";
        Assert.assertEquals(actPrice,expPrice);

        WebElement miles = driver.findElement(By.name("maximum_distance"));
        BrowserUtils.selectBy(miles,"40", "value");

        WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
        zip.clear();
        Thread.sleep(1000);
        zip.sendKeys("66056");

        WebElement submit = driver.findElement(By.cssSelector(".sds-button"));
        Thread.sleep(1000);
        submit.click();

        WebElement header = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        Thread.sleep(1000);
        BrowserUtils.selectBy(sortBy, "list_price", "value");

        List<WebElement> allNames = driver.findElements(By.xpath("h2[@class='title']"));
        for ( WebElement title : allNames) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));

        }

        List<WebElement> allPrice = driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPrice = new ArrayList<>();//do not do comparison in Strings! Because it will be 1,11,2,3
        List<Integer> expectedPrice = new ArrayList<>();
        Thread.sleep(3000);

        for(int i = 0; i<allPrice.size(); i++){
            String priceCar = BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",","");
            actualPrice.add(Integer.parseInt(priceCar));
            expectedPrice.add(Integer.parseInt(priceCar));
        }

        //Collections.sort(actualPrice);//for promotion cars. Otherwise, NEVER touch the ACTUAL
        Collections.sort(expectedPrice);
        //Collections.reverse(expectedPrice); For the descending order : 1. sort, 2. reverse
        System.out.println(expectedPrice);
        System.out.println(actualPrice);

        Assert.assertEquals(actualPrice,expectedPrice);
        driver.quit();

        }
    }

