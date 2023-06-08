package COM.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CustomerPage {

/*
    TASK:
            1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
            7-Validate "Deposit Successful
            8-Click Withdrawl and put 300
            9-Validate "Transaction successful"
            10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
            14-Quit the driver

    NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;
    @FindBy(xpath = "//button[.='Login']")
    WebElement logInButton;
    @FindBy(id = "userSelect")
    WebElement selectNameFromDropDown;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeHeader;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(tagName = "input")
    WebElement amountInput;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositFinalButton;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositConfirmation;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalButton;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawalFinalButton;
    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement withdrawalConfirmation;
    @FindBy(xpath = "//div[@class='center']//strong[2]")
    WebElement balanceAmount;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositAmountFromTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawalAmountFromTransaction;
    @FindBy (xpath = "//button[.='Back']")
    WebElement backButton;


    public void loginFunctionality(String fullName, String expectedHeader) throws InterruptedException {

        homeButton.click();
        customerLogin.click();

        Select select= new Select(selectNameFromDropDown);
        select.selectByVisibleText(fullName);
        selectNameFromDropDown.click();

        logInButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeHeader),expectedHeader);
    }

    public void balanceAndCustomerDeposit(String expectedDepositConfirmation,String expectedWithdrawalConfirmation, String expectedBalanceAmount) throws InterruptedException {

        depositButton.click();
        amountInput.clear(); //there is 0 which is not disappear
        amountInput.sendKeys("500");
        Thread.sleep(2000);
        depositFinalButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(depositConfirmation),expectedDepositConfirmation);//deposit successful
        withdrawalButton.click();
        Thread.sleep(2000);
        amountInput.sendKeys("300");
        Thread.sleep(2000);
        withdrawalFinalButton.click();

        Assert.assertEquals(BrowserUtils.getText(withdrawalConfirmation),expectedWithdrawalConfirmation);

        Assert.assertEquals(BrowserUtils.getText(balanceAmount),expectedBalanceAmount);
        int balance=Integer.parseInt(BrowserUtils.getText(balanceAmount));
        Thread.sleep(1500);
        transactionButton.click();

        int differenceAmountInTransaction=Integer.parseInt(BrowserUtils.getText(depositAmountFromTransaction))-Integer.parseInt(BrowserUtils.getText(withdrawalAmountFromTransaction));
        Assert.assertEquals(differenceAmountInTransaction,balance);
    }
}
