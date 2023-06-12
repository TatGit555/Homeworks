package COM.test.blaze.pages;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MacBookPage {

    public MacBookPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy (tagName = "h2")
    WebElement laptopName;
    @FindBy (tagName= "h3")
    WebElement laptopPrice;
    @FindBy (xpath = "//div[@id='myTabContent']")
    WebElement laptopInfo;
    @FindBy (linkText="Add to cart")
    WebElement addToCart;

    public void macBookInfoValidation(String expectedName,String expectedPrice, String expectedInfo) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(laptopName), expectedName);
        Assert.assertEquals(BrowserUtils.getText(laptopPrice), expectedPrice);
        //Assert.assertEquals(BrowserUtils.getText(laptopInfo), expectedInfo);
    }
    public void addToCart(WebDriver driver, String expectedAlert) throws InterruptedException {
        addToCart.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlert);
        alert.accept();
    }
}
