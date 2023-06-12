package COM.test.bank.tests;

import COM.test.bank.pages.BankLoginPage;
import COM.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{
    @Test
    public void validateAddCustomer() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60123", "Customer added successfully with customer");
    }
        @Test
        public void validateOpenAccount() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

            BankLoginPage loginPage = new BankLoginPage(driver);
            loginPage.clickManagerButton();

            BankManagerPage bankManagerPage = new BankManagerPage(driver);
            bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60123", "Customer added successfully with customer");
            bankManagerPage.openAccountFunctionality(driver,"Ahmet Baldir","Dollar", "Account created successfully with account Number");
        }

    @Test
    public void validateAllInfo() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        //open account
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60123", "Customer added successfully with customer");

        //add customer
        bankManagerPage.openAccountFunctionality(driver,"Ahmet Baldir","Dollar", "Account created successfully with account Number");

        //search customer
        bankManagerPage.customersButtonFunctionality("Ahmet","Baldir","60123");
    }

}

