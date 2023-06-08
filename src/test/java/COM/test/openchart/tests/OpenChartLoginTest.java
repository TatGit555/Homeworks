package COM.test.openchart.tests;

import COM.test.openchart.pages.OpenChartPage;
import Utils.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{
    @Test
    public void happyValidationLogin(){
        OpenChartPage openChartPage = new OpenChartPage(driver);
        openChartPage.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(), "Administration");
    }
    @Test
    public void negativeValidationLogin() throws InterruptedException {
        OpenChartPage openChartPage = new OpenChartPage(driver);
        openChartPage.loginFunctionality("wrong", "demo");
        Thread.sleep(1500);
        Assert.assertEquals(openChartPage.errorMessage(), "No match for Username and/or Password.");
    }
}
