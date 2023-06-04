package Homeworks;

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

public class Homework2 {
    @Test
    public void case1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        Assert.assertEquals(BrowserUtils.getTitleWithJS(driver),"Web Orders Login" );
        Thread.sleep(200);

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(200);
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(200);
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector(".button"));
        Thread.sleep(200);
        login.click();

        WebElement title2 = driver.findElement(By.xpath("//h1"));
        String actualtitle2 = BrowserUtils.getText(title2);
        String exptitle2 = "Web Orders";
        Assert.assertEquals(actualtitle2,exptitle2);
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualheader = BrowserUtils.getText(header);
        String expheader = "List of All Orders";
        Assert.assertEquals(actualheader,expheader);
        Thread.sleep(1000);

        driver.quit();
    }

    @Test
    public void case2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(200);
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(200);
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector(".button"));
        Thread.sleep(200);
        login.click();

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        Thread.sleep(200);
        allProducts.click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".selected")).isEnabled());

        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");

        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));

        driver.quit();
    }

    @Test
    public void case3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(200);
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(200);
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector(".button"));
        Thread.sleep(200);
        login.click();

        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        for (WebElement link : allLinks) {
            System.out.println(link.getAttribute("href"));
            Thread.sleep(1000);
        }
        //Validate their href values are equals to :
        //"Default.aspx"
        //"Products.aspx"
        //"Process.aspx"

        //Assert.assertEquals(contains);
        driver.quit();

    }
    @Test
    public void case4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(200);
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Thread.sleep(200);
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector(".button"));
        Thread.sleep(200);
        login.click();

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        Thread.sleep(200);
        order.click();

        WebElement product = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select select = new Select(product);
        select.selectByValue("ScreenSaver");

        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(2000);
        quantity.sendKeys("5");
        WebElement name = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        Thread.sleep(2000);
        name.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        Thread.sleep(2000);
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        Thread.sleep(2000);
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        Thread.sleep(2000);
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        Thread.sleep(2000);
        zip.sendKeys("60018");

        WebElement button = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        button.click();
        WebElement card = driver.findElement((By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")));
        Thread.sleep(2000);
        card.sendKeys("444993876233");
        WebElement date = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        Thread.sleep(2000);
        date.sendKeys("03/24");
        WebElement process = driver.findElement(By.cssSelector(".btn_light"));
        process.click();
        Thread.sleep(2000);

        //Test Case 4.2
        WebElement message = driver.findElement(By.xpath("//strong"));
        //System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed());

        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();

        List <WebElement> actualList = driver.findElements(By.xpath("//tr[2]//td"));
        List <String> expectedList = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/04/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");

        for(int i=1, j=0; i<actualList.size()-1; i++, j++ ){
            Assert.assertEquals(BrowserUtils.getText(actualList.get(i)), expectedList.get(j));
            System.out.println(actualList.get(i).getText());
        }
        driver.quit();
    }





}
