package COM.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className="btn-close")
    WebElement xButton;
    @FindBy(xpath = "//a[@href='#collapse-5']")
    WebElement customers;
    @FindBy(xpath ="//a[.='Customers']")
    WebElement subCustomers;

public void homePageXButton() {
    xButton.click();
}
public void choosingCustomers() {
    customers.click();
    subCustomers.click();

}
}