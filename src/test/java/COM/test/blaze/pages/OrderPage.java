package COM.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.BrokenBarrierException;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='month']")
    WebElement month;
    @FindBy(xpath = "//input[@id='year']")
    WebElement year;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement thankYouMessage;
    @FindBy (xpath = "//button[.='OK']")
    WebElement OkButton;

    public void purchaseFunctionality(String name, String country, String city, String card, String month, String year, String expectedMessage) throws InterruptedException {
      this.name.sendKeys(name);
      Thread.sleep(2000);
      this.country.sendKeys(country);
      Thread.sleep(2000);
      this.city.sendKeys(city);
      Thread.sleep(2000);
      this.creditCard.sendKeys(card);
      Thread.sleep(2000);
      this.month.sendKeys(month);
      Thread.sleep(2000);
      this.year.sendKeys(year);
      Thread.sleep(2000);
      purchaseButton.click();

      Assert.assertEquals(BrowserUtils.getText(thankYouMessage), expectedMessage);
      OkButton.click();
    }
}
