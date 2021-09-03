package pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

/**
 * Created by yardenmorshtein on 03/09/2021.
 */
public class CalcElements {

    protected static final Logger logger = LogManager.getLogger(CalcElements.class);
    private final WebDriverWait waitDriver;


    public CalcElements(WebDriver driver) {
        waitDriver = new WebDriverWait(driver,10);
    }

    public void clickCalcNumButton(int number){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("Btn" + number))).click();
    }

    public void clickOnPlusButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnPlus"))).click();
    }

    public void clickOnMinusButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnMinus"))).click();
    }

    public void clickOnMultiplyButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnMult"))).click();
    }

    public void clickOnEqualsButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnCalc"))).click();
    }

    public void clickOnSinCalcButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnSin"))).click();
    }

    public void clickOnClearCalcButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnClear"))).click();
    }

    public void clickOnRightParenthesesCalcButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnParanR"))).click();
    }

    public void clickOnLeftParenthesesCalcButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnParanL"))).click();
    }

    public String getCalcResult() throws InterruptedException {
        Thread.sleep(2000);
       return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("input"))).getAttribute("value");
    }

    public String calcGetAllHistory(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("hist"))).click();
        String historyList[] = new String[4];
        for (int i = 0 ; i <= 3 ; i++) {
            int j = i+1;
            String histRecordFormula = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='histframe']/ul/li["+ j +"]//p[@class='l']"))).getText();
            String histRecordResult = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='histframe']/ul/li["+ j +"]//p[@class='r']"))).getText();

            historyList[i] = histRecordFormula + histRecordResult;
            logger.info("Calculator History Record Number - {} = {}",(i+1),historyList[i]);
        }
        return Arrays.toString(historyList);
    }

}
