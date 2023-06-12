package COM.test.spruceEats.tests;

import COM.test.spruceEats.pages.FishAndSeafoodPage;
import COM.test.spruceEats.pages.FishForDinnerPage;
import COM.test.spruceEats.pages.SpruceHomePage;
import org.testng.annotations.Test;

public class FishForDinnerTest extends SpruceEatsTestBase{

    @Test
    public void validateRecipeFunctionality() throws InterruptedException {

        SpruceHomePage home = new SpruceHomePage(driver);
        home.chooseTheRecipe(driver,"Fish & Seafood");

        FishAndSeafoodPage seafood = new FishAndSeafoodPage(driver);
        seafood.searchDinner(driver, "Fish for dinner");

        FishForDinnerPage fish = new FishForDinnerPage(driver);
        fish.validateRecipeName(driver, "6-Ingredient Roasted Salmon Fillets");
    }
}
