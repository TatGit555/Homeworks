package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//for the bug

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");


        WebElement name = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        name.sendKeys("Den");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Sobakin");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("dsob45689@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("123-456-789");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("abcd");
        WebElement passwordconfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordconfirm.sendKeys("abcd");

       // WebElement subscribe = driver.findElement(By.xpath("//[@name='newsletter']"));
        //subscribe.click();
        WebElement privacy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacy.click();

        WebElement cont = driver.findElement(By.xpath("//input[@value='Continue']"));
        cont.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text),'Been Created']"));
        String actualheader = header.getText().trim();
        String expectedheader = "Your Account Has Been Created!";
        System.out.println(actualheader.equals(expectedheader) ? "PASSED" : "FAILED");

        WebElement cont2 = driver.findElement(By.xpath("//a[.='Continue']"));
        cont2.click();













    }
}
