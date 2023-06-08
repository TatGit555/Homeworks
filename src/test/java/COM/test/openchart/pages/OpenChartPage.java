package COM.test.openchart.pages;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class OpenChartPage {
    public OpenChartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-username")
    WebElement username;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(xpath = "//button")
    WebElement logInButton;
    @FindBy(xpath = "//h5")
    WebElement notificationMessage;
    @FindBy(id="alert")
    WebElement errorMessage;



    public void loginFunctionality(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        logInButton.click();
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
    public WebDriver driver;

}



