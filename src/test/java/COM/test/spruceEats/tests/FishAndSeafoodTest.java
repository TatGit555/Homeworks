package COM.test.spruceEats.tests;

import COM.test.spruceEats.pages.FishAndSeafoodPage;
import COM.test.spruceEats.pages.SpruceHomePage;
import org.testng.annotations.Test;

public class FishAndSeafoodTest extends SpruceEatsTestBase {
    @Test
    public void searchDinnerFunctionality() throws InterruptedException {

        FishAndSeafoodPage fishAndSeafoodPage = new FishAndSeafoodPage(driver);
        fishAndSeafoodPage.searchDinner(driver, "Fish for dinner");
    }
}
