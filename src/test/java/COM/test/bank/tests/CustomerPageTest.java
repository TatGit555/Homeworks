package COM.test.bank.tests;

import COM.test.bank.pages.BankLoginPage;
import COM.test.bank.pages.BankManagerPage;
import COM.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerPageTest {

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

        //Homework

        //go to homepage and login
        CustomerPage customerPage = new CustomerPage(driver);


        customerPage.loginFunctionality("Ahmet Baldir", "Welcome Ahmet Baldir !!");
        //balance and withdrawal

        customerPage.balanceAndCustomerDeposit( "Deposit Successful", "Transaction successful","200");

    }
}
