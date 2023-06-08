package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAfterMethod {

    @BeforeMethod
    public void setup(){
        System.out.println("BeforeMethod");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
    }
    /*
   BeforeMethod
test1
after method
BeforeMethod
test2
after method
     */
}
