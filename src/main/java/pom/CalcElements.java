package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by yardenmorshtein on 02/09/2021.
 */
public class CalcElements {

    private final WebDriverWait waitDriver;


    public CalcElements(WebDriver driver) {
        waitDriver = new WebDriverWait(driver,10);
    }

    public void clickOnNumButton(int number){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("Btn" + number))).click();
    }

    public void clickOnPlusButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnPlus"))).click();
    }

    public void clickOnMinusButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnMinus"))).click();
    }

    public void clickOnEqualsButton(){
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("BtnCalc"))).click();
    }

    public String getCalcResult(){
       return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("BtnCalc"))).getText();
    }

}
