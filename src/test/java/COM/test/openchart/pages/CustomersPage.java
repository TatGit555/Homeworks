package COM.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomersPage {

    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addButton;
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @FindBy(id = "input-email")
    WebElement email;
    @FindBy(id = "input-telephone")
    WebElement telephone;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;
    @FindBy(id = "input-newsletter")
    WebElement newsletterCheck;
    @FindBy(id = "input-status")
    WebElement statusCheck;
    @FindBy(id = "input-safe")
    WebElement safeCheck;
    //List<WebElement> checkOther = driver.findElements(By.xpath("//input[@class='form-check-input']"));

    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveNewCustomerButton;
    @FindBy(id = "alert")
    WebElement warningMessage;

    public void addNewCustomerFunctionality
            (WebDriver driver, String firstName, String lastName, String email, String telephone, String password) throws InterruptedException {

        addButton.click();
        Thread.sleep(500);

        this.firstName.sendKeys(firstName);
        Thread.sleep(500);
        this.lastName.sendKeys(lastName);
        Thread.sleep(500);
        this.email.sendKeys(email);
        Thread.sleep(500);
        this.telephone.sendKeys(telephone);
        Thread.sleep(500);
        this.password.sendKeys(password);
        Thread.sleep(500);
        this.passwordConfirm.sendKeys(password);
        Thread.sleep(500);

        Actions act = new Actions(driver);
        Thread.sleep(500);
        act.scrollByAmount(700, 700);
        act.click(newsletterCheck).perform();
        //act.click(statusCheck).perform();
        Thread.sleep(500);
        act.click(safeCheck).perform();
        Thread.sleep(500);
        act.scrollByAmount(1400, -900);
        Thread.sleep(500);
        act.click(saveNewCustomerButton).perform();
    }

    public void validationMessageAlert(String warningMessage, String expectedMessage) throws InterruptedException {
        Assert.assertEquals(warningMessage, expectedMessage);

    }
}


