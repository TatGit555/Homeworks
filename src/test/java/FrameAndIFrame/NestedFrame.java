package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //Name or ID Frame
        driver.switchTo().frame("frame-top");

        //WebElement iframe
        //left frame
        WebElement iFrameLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iFrameLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        //middle frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));

        //right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

        //bottom
        //driver.switchTo().parentFrame();//switch to top
        //driver.switchTo().parentFrame();//switch to parent ,because top and bottom are siblings, we CAN"T switch from siblings
        driver.switchTo().defaultContent(); //goes automatically to the main html (no matter how many)

        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));


    }
}
