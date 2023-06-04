package SelectClass;

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
import java.util.TreeSet;

public class SelectPractice {
    @Test
            public void validate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/12247/Desktop/Techtorial.html");

        WebElement countries = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countries);
        String actual = country.getFirstSelectedOption().getText().trim();
        String expected = "UNITED STATES";
        Assert.assertEquals(actual,expected);

        //2nd task to print out all countries and count
       List<WebElement> allOptions = country.getOptions();

       int amountOfCountries = 0;
       for(int i =0; i<allOptions.size(); i++){
           amountOfCountries++;
           Thread.sleep(500);
       }
       //System.out.println(countries.getText().trim());//print all countries
        System.out.println(amountOfCountries);

        //test 3
        // choose your own country with visible Text method
        country.selectByVisibleText("Belarus");
        Thread.sleep(500);

        //favourite country
        country.selectByValue("95");
        Thread.sleep(500);

        //tourism country
        country.selectByIndex(34);

    }









    }
