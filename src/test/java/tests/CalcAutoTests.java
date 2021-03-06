package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestListener;

/**
 * Created by yardenmorshtein on 03/09/2021.
 */
@Listeners(TestListener.class)
public class CalcAutoTests extends BaseTests {

    @BeforeClass
    public void beforeClass()  {
    super.beforeClass();
    }

    @Test(priority = 1)
    public void checkFor2plus3() throws InterruptedException {
        calcActions.clickCalcNumButton(2);
        calcActions.clickOnPlusButton();
        calcActions.clickCalcNumButton(3);
        calcActions.clickOnEqualsButton();
        Assert.assertEquals(calcActions.getCalcResult(),"5");
    }

    @Test(priority = 2)
    public void checkFor10minus2() throws InterruptedException {
        calcActions.clickCalcNumButton(1);
        calcActions.clickCalcNumButton(0);
        calcActions.clickOnMinusButton();
        calcActions.clickCalcNumButton(2);
        calcActions.clickOnEqualsButton();
        Assert.assertEquals(calcActions.getCalcResult(),"8");
    }

    @Test(priority = 3)
    public void checkFor10minus2AndMore() throws InterruptedException {
        calcActions.clickOnLeftParenthesesCalcButton();
        calcActions.clickCalcNumButton(1);
        calcActions.clickCalcNumButton(0);
        calcActions.clickOnMinusButton();
        calcActions.clickCalcNumButton(2);
        calcActions.clickOnRightParenthesesCalcButton();
        calcActions.clickOnMultiplyButton();
        calcActions.clickCalcNumButton(2);
        calcActions.clickOnEqualsButton();
        Assert.assertNotEquals(calcActions.getCalcResult(),"20");
    }

    @Test(priority = 4)
    public void checkForSin30() throws InterruptedException {
        calcActions.clickOnSinCalcButton();
        calcActions.clickCalcNumButton(3);
        calcActions.clickCalcNumButton(0);
        calcActions.clickOnRightParenthesesCalcButton();
        calcActions.clickOnEqualsButton();
        Assert.assertEquals(calcActions.getCalcResult(),"0.5");
    }

    @Test(priority = 5)
    public void checkFormulasValidation() {
        String expectedHistory = "[sin(30)= 0.5, (10-2)*2= 16, 10-2= 8, 2+3= 5]";
        Assert.assertEquals(calcActions.calcGetAllHistory(),expectedHistory);
    }

    @AfterMethod
    public void afterMethod(){
        calcActions.clickOnClearCalcButton();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.close();
    }
}
