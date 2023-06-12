package COM.test.spruceEats.tests;

import COM.test.spruceEats.pages.SpruceHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageTest extends SpruceEatsTestBase{
    @Test
        public void choosingRecipeFunctionality() throws InterruptedException {
        SpruceHomePage home = new SpruceHomePage(driver);
        home.chooseTheRecipe(driver,"Fish & Seafood");
    }
}
