package COM.test.spruceEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishAndSeafoodPage {
    public FishAndSeafoodPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBar;

    @FindBy(xpath = "//button[@id='button_1-0']")
    WebElement searchButton;

    public void searchDinner(WebDriver driver,String recipe) throws InterruptedException {
        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver, searchBar);
        searchBar.sendKeys(recipe);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,searchButton);
        Thread.sleep(3000);
    }
}
