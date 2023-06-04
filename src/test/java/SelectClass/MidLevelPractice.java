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
import java.util.Arrays;
import java.util.List;

public class MidLevelPractice {

    @Test
    public void validateOrder() throws InterruptedException {

        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Thread.sleep(500);

        WebElement passengers = driver.findElement(By.name("passCount"));
        Select passengerChoice = new Select(passengers);
        passengerChoice.selectByValue("4");
        Thread.sleep(500);

        WebElement departure = driver.findElement(By.name("fromPort"));
        Select departureFrom = new Select(departure);
        departureFrom.selectByVisibleText("Acapulco");
        Thread.sleep(500);

        WebElement onDate = driver.findElement(By.name("fromMonth"));
        Select onDat = new Select(onDate);
        onDat.selectByIndex(9);
        Thread.sleep(500);

        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDa = new Select(onDay);
        onDa.selectByVisibleText("15");
        Thread.sleep(500);

        WebElement arrival = driver.findElement(By.name("toPort"));
        Select arrivalTo = new Select(arrival);
        arrivalTo.selectByValue("Paris");
        Thread.sleep(500);

        WebElement toDate = driver.findElement(By.name("toMonth"));
        Select toDat = new Select(toDate);
        toDat.selectByValue("12");
        Thread.sleep(500);

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDa = new Select(toDay);
        toDa.selectByVisibleText("15");
        Thread.sleep(500);

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select air = new Select(airline);
        List<WebElement> actual = air.getOptions();
        List <String> expected = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0; i<actual.size(); i++){
        Assert.assertEquals(actual.get(i).getText().trim(),expected.get(i));
        }

        Thread.sleep(500);
        air.selectByIndex(2);

        WebElement cont = driver.findElement(By.xpath("//input[@name='findFlights']"));
        cont.click();
        Thread.sleep(500);

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actHeader = header.getText().trim();
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(actHeader,expectedHeader);

    }

    @Test
    public void shortCuts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Thread.sleep(500);

        WebElement passengers = driver.findElement(By.name("passCount"));
        //Select passengerChoice = new Select(passengers);
        //passengerChoice.selectByValue("4");
        BrowserUtils.selectBy(passengers,"4","value");
        Thread.sleep(500);

        WebElement departure = driver.findElement(By.name("fromPort"));
        //Select departureFrom = new Select(departure);
        //departureFrom.selectByVisibleText("Acapulco");
        Thread.sleep(500);

        WebElement onDate = driver.findElement(By.name("fromMonth"));
        //Select onDat = new Select(onDate);
        //onDat.selectByIndex(9);
        BrowserUtils.selectBy(onDate,"9","index");
        Thread.sleep(500);

        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        //Select onDa = new Select(onDay);
        //onDa.selectByVisibleText("15");
        BrowserUtils.selectBy(onDay,"15","index");
        Thread.sleep(500);

        WebElement arrival = driver.findElement(By.name("toPort"));
        //Select arrivalTo = new Select(arrival);
        //arrivalTo.selectByValue("Paris");
        BrowserUtils.selectBy(arrival,"Paris","value");
        Thread.sleep(500);

        WebElement toDate = driver.findElement(By.name("toMonth"));
        //Select toDat = new Select(toDate);
        //toDat.selectByValue("12");
        BrowserUtils.selectBy(toDate,"12","value");
        Thread.sleep(500);

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        //Select toDa = new Select(toDay);
        //toDa.selectByVisibleText("15");
        BrowserUtils.selectBy(toDay, "15","text");
        Thread.sleep(500);

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select air = new Select(airline);
        List<WebElement> actual = air.getOptions();
        List <String> expected = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0; i<actual.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(actual.get(i)),expected.get(i));
        }

        Thread.sleep(500);
        air.selectByIndex(2);

        WebElement cont = driver.findElement(By.xpath("//input[@name='findFlights']"));
        cont.click();
        Thread.sleep(500);

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actHeader = header.getText().trim();
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(actHeader,expectedHeader);

    }
}
