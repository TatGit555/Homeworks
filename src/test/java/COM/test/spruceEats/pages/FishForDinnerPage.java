package COM.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishForDinnerPage {

    WebDriver driver;
    public FishForDinnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#starRating_score_4Star")
    WebElement starRating;
    @FindBy (css = "#pop_search_editor")
    WebElement editorChoice;
    @FindBy (xpath = "//h4[@class='card__title']")
    WebElement salmonRecipe;

    public void validateRecipeName (WebDriver driver,String expectedName) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,starRating);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,editorChoice);
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(salmonRecipe),expectedName);

    }
}


