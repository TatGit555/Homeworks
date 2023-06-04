package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertion {

    public int multiplication (int number1, int number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplication(){
        int actualResult = multiplication(2,4);
        int expectedResult = 8;
        // if(actualResult==expectedResult){    // not nice and too amateur
        //    System.out.println("Passed");
       // }else {
        //   System.out.println("Failed");
        //}

        Assert.assertEquals(actualResult,expectedResult);//passed means green v on the left
        Assert.assertTrue(actualResult==expectedResult);// another way to validate by boolean

    }

    @Test
    public void validateZero(){
        int actual = multiplication(0, 9);
        int expected = 0;
        Assert.assertFalse(actual!=expected);

    }
    @Test
    public void validateNegativeWithPositive(){
        int actual = multiplication(-1, 5);
        int expected =-5;
        Assert.assertEquals(multiplication(-1,5),-5);
    }

    @Test
    public void validateNegativeWithNegative(){
        int actual = multiplication(-1, -5);
        int expected = 5;
        Assert.assertEquals(multiplication(-1,-5),5);

    }


}
