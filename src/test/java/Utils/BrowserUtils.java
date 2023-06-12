package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.Set;

public class BrowserUtils {
    public static String getText(WebElement element) {
        return element.getText().trim();
    }


    public static void selectBy(WebElement location, String value, String methodName) {
        Select select = new Select(location);
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("your value name is not correct");
                Assert.assertTrue(false);
        }
    }


    public static String getTitleWithJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    //method for scroll
    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    //switchBy id for the first and last tab only
    public static void switchById(WebDriver driver) {
        String mainPageId = driver.getWindowHandle(); //main current
        Set<String> allPagesId = driver.getWindowHandles();

        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    //switch by Title for multiple tabs
    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPagesId = driver.getWindowHandles();

        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {  //if title contains title then do not switch
                break;
            }
        }
    }
    public static void getScreenShot (WebDriver driver, String packageName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("st/test/java/" + packageName + "/");
    }
}










