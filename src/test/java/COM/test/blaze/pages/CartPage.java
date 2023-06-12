package COM.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName="//td")
    List<WebElement> itemsInfo;
    @FindBy (xpath = "//button[contains(text(),'Order')]")
    WebElement placeOrderButton;

    public void reviewCart(String expectedName, String expectedPrice) throws InterruptedException {
        List<String> expectedInfo = Arrays.asList("",expectedName, expectedPrice, "");

        for(int i=1; i< itemsInfo.size()-1; i++){
            Assert.assertEquals(BrowserUtils.getText(itemsInfo.get(i)),expectedInfo.get(i));
            }
        Thread.sleep(2000);
        placeOrderButton.click();
        }



    }

