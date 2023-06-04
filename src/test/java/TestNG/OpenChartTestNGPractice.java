package TestNG;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement user = driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button"));
        Thread.sleep(1500);
        login.click();
        Thread.sleep(1500);

        String actual = driver.getTitle().trim();
        String expected = "Dashboard";
        Thread.sleep(3000);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement user2 = driver.findElement(By.cssSelector("#input-username"));
        user2.sendKeys("demo");
        WebElement password2 = driver.findElement(By.cssSelector("#input-password"));
        password2.sendKeys("dumo");
        WebElement login2 = driver.findElement(By.xpath("//button"));
        Thread.sleep(1500);
        login2.click();
        Thread.sleep(1500);

        WebElement message = driver.findElement(By.cssSelector("#alert"));

        String actual2 = message.getText().trim();
        String expected2 = "No match for Username and/or Password.";
        Thread.sleep(3000);
        Assert.assertEquals(actual2, expected2);
    }

    @Test
    public void validateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement user = driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button"));
        Thread.sleep(1500);
        login.click();

        WebElement close = driver.findElement(By.cssSelector(".btn-close"));
        close.click();
        Thread.sleep(1500);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        Thread.sleep(1500);
        catalog.click();
        Thread.sleep(1500);

        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));

        Assert.assertTrue(products.isDisplayed());
        Assert.assertTrue(products.isEnabled());
        products.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < checkboxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(checkboxes.get(i).isDisplayed());
            Assert.assertTrue(checkboxes.get(i).isEnabled());
            Assert.assertFalse(checkboxes.get(i).isSelected());
            checkboxes.get(i).click();
            Thread.sleep(1000);

            Assert.assertTrue(checkboxes.get(i).isSelected());//what's the point to use it twice
            checkboxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
    }

        @Test
        public void validateProductName() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.opencart.com/admin/");

            WebElement user = driver.findElement(By.cssSelector("#input-username"));
            user.sendKeys("demo");
            WebElement password = driver.findElement(By.cssSelector("#input-password"));
            password.sendKeys("demo");
            WebElement login = driver.findElement(By.xpath("//button"));
            Thread.sleep(1500);
            login.click();

            WebElement close = driver.findElement(By.cssSelector(".btn-close"));
            close.click();
            Thread.sleep(1500);

            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            Thread.sleep(1500);
            catalog.click();
            Thread.sleep(1500);

            WebElement products = driver.findElement(By.xpath("//a[.='Products']"));

            Assert.assertTrue(products.isDisplayed());
            Assert.assertTrue(products.isEnabled());
            products.click();

            /*
            Test Case:
            1. Click the Product Name button
            2. Create 2 ArrayLists ( actual data and expected data)
            3. For (int i=1)
            *store all the name for both of the list
            4. Expected List --> use Collections.sort(expected)
                             --> Collections.reverse(expected)
            Assert.equals(actual,expected)
             */

            WebElement productNamesButton = driver.findElement(By.xpath("//a[.='Product Name']"));
            productNamesButton.click();
            Thread.sleep(500);
            List<WebElement> each = driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements
            ArrayList<String> actualProducts = new ArrayList<>();
            ArrayList<String> expectedProducts = new ArrayList<>();
            Thread.sleep(500);

            for (int i=1; i<each.size(); i++){
                Thread.sleep(500);
                actualProducts.add(each.get(i).getText().toLowerCase().trim());
                Thread.sleep(500);
                expectedProducts.add(each.get(i).getText().toLowerCase().trim());

            }

            WebElement productNamesButton2 = driver.findElement(By.xpath("//a[.='Product Name']"));
            Thread.sleep(3000);
            productNamesButton2.click();
            Thread.sleep(3000);

            Collections.sort(expectedProducts);
            Thread.sleep(3000);
            Assert.assertEquals(actualProducts,expectedProducts);
            Thread.sleep(3000);
            System.out.println(actualProducts);
            System.out.println(expectedProducts);

            //for descending order the same

            /*Thread.sleep(3000);
            Collections.sort(expectedProducts);
            Collections.reverse(expectedProducts);
            Assert.assertEquals(actualProducts,expectedProducts);

             */







        }
    }














