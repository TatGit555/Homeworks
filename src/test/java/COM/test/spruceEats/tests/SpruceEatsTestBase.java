package COM.test.spruceEats.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SpruceEatsTestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");

    }
    @AfterMethod
    public void tearDown(ITestResult itestresult){
//        if(!itestresult.isSuccess()){
//            BrowserUtils.getScreenShot(driver,"SprucePictures");
//        }
       // driver.quit();
    }
}