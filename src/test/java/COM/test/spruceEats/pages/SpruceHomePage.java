package COM.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class SpruceHomePage {
    public SpruceHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsOptions;

    @FindBy(xpath = "//li[@class='global-nav__list-item js-global-nav-item'][3]//li")
    List<WebElement> allOptions;

    public void chooseTheRecipe(WebDriver driver,String choice) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredientsOptions).perform();

        for (int i =0; i< allOptions.size(); i++) {
            if (BrowserUtils.getText(allOptions.get(i)).equalsIgnoreCase(choice)) {
                Thread.sleep(1000);
                actions.click(allOptions.get(i)).perform();
                break;
            }
        }
    }
}
