package COM.test.blaze.tests;

import COM.test.blaze.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MacBookTest extends BlazeTestBase {
    @Test
    public void validationProductChoice() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.chooseProduct("Laptops");

        LaptopPage laptop = new LaptopPage(driver);
        laptop.chooseBrand("MacBook Pro");

        MacBookPage macbook = new MacBookPage(driver);
        macbook.macBookInfoValidation("MacBook Pro","$1100 *includes tax","Product description Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macbook.addToCart(driver, "Product added");

        //
        home.goToCartButton();

        CartPage cart = new CartPage(driver);
        cart.reviewCart("Macbook Pro", "1100");

        OrderPage order = new OrderPage(driver);
        order.purchaseFunctionality("So","USA","Chi","123","12","23","Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/cart.html");

    }
}
