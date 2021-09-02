package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by yardenmorshtein on 03/09/2021.
 */
public class CalcAutoTests extends BaseTests {


    @BeforeClass
    public void beforeClass()  {
    super.beforeClass();
    }

    @BeforeMethod
    public void beforeMethod(){
    }

    @Test(priority = 1)
    public void checkFor2plus3() {
        calcActions.clickOnNumButton(2);
        calcActions.clickOnPlusButton();
        calcActions.clickOnNumButton(3);
        calcActions.clickOnEqualsButton();
        Assert.assertEquals(calcActions.getCalcResult(),"=5");

    }

    @Test(priority = 2)
    public void checkFor10minus2() {

    }

    @Test(priority = 3)
    public void checkFor10minus2AndMore() {

    }

    @Test(priority = 4)
    public void checkForSin30() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
    }
}
