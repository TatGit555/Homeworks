package TestNG;

import org.testng.annotations.Test;

public class TestNgIntro {

    //execution by ascending order alphabetically by name.
    //To change the order of execution to put (priority=1)
    @Test(priority = 1, invocationCount = 10)
    public void test1(){
        System.out.println("I am test 1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("I am test 2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("I am test 3");
    }
}
