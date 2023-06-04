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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClass {

    @Test
    public void selectMethods() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //create an Object

        Select choice = new Select(optionBox); // it means I will choose the options from THAT BOX
        //visibleText
        choice.selectByVisibleText("Option 2");
        Thread.sleep(2000);

        choice.selectByValue("1");
        Thread.sleep(2000);
        choice.selectByIndex(2);//not suggested. Starts from zero (as any index)
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();//chosen last one, Option 2
        String expectedDefaultOption = "Option 2";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);
        //System.out.println(actualDefaultOption);//Option 2

        //validate the options from the dropdown
        List<WebElement> actualOptions = choice.getOptions(); //coming from system
        List<String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2"); //asList because we need ascending order

        for(int i=0; i<actualOptions.size(); i++){
            Assert.assertEquals(actualOptions.get(i).getText().trim(),expectedOptions.get(i).trim());
        }













    }

}
