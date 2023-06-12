package COM.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".hrefch")
    List<WebElement> allLaptops;

    public void chooseBrand(String brand) throws InterruptedException {
Thread.sleep(2000);
            for(WebElement laptop : allLaptops){
                if(BrowserUtils.getText(laptop).equals(brand)){
                    laptop.click();
                    break;
                }
            }



    }
}
