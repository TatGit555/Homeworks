package COM.test.openchart.tests;

import COM.test.openchart.pages.CustomersPage;
import COM.test.openchart.pages.HomePage;
import COM.test.openchart.pages.OpenChartPage;
import Utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartHomeCustomersTest extends OpenChartTestBase {

    @Test
    public void happyValidationLogin() throws InterruptedException {
        OpenChartPage openChartPage = new OpenChartPage(driver);
        openChartPage.loginFunctionality("demo", "demo");
        //Assert.assertEquals(driver.getTitle().trim(), "Administration");
    }

        @Test
        public void addCustomerValidation () throws InterruptedException {
        //  1-Click "X" button. (HomePage)
        HomePage homePage = new HomePage(driver);
        homePage.homePageXButton();
        //2-CLick Customers from left side and click sub Customers button (still HomePage)
        homePage.choosingCustomers();

        //3-Click + sign on the top right (CustomerPage)
        // 4-Fill all the blanks and enable NewsLetter,Status,Safe and CLick save button top left(CustomerPage)
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.addNewCustomerFunctionality(driver, "Sobaka", "Sobakina", "s@email.com", "224356", "den");

        // 5-Validate message "Warning:You do not have permission to modify customers!" (Customer Test) -->call the method in here
        customersPage.validationMessageAlert(driver.getTitle(), "Warning:You do not have permission to modify customers!");
    }
}


