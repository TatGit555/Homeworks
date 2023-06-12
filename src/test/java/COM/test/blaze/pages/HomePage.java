package COM.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@id='itemc']")
    List<WebElement> categories;
    @FindBy (id="cartur")
    WebElement cartButton;

public void chooseProduct(String option){
    for (WebElement category: categories){
        if (BrowserUtils.getText(category).equals(option)){
            category.click();
            break;
        }
    }
}
public void goToCartButton(){
    cartButton.click();
}

}