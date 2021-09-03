package utils;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * Created by yardenmorshtein on 03/09/2021.
 */
public class TestListener extends BaseTests implements ITestListener {


    protected static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("\n**********************************************************************************************" +
                        "\n*\n* Test started: '{}'\n*\n" +
                        "**********************************************************************************************\n",
                iTestResult.getName().trim());
        ExtentTestManager.startTest(iTestResult.getName().trim(),"Calc Tests");

    }

    @Override
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        logger.info("\n**********************************************************************************************" +
                        "\n*\n* \"Test finished with SUCCESS:\" '{}'\n*\n" +
                        "**********************************************************************************************\n\n\n\n\n",
                iTestResult.getName().trim());
        ExtentTestManager.getTest().log(Status.PASS,"Test Passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        logger.error("*************** Error '{}' Test has failed ***************\n",iTestResult.getName().trim());
        ExtentTestManager.getTest().log(Status.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("*************** Skipping '{}' Test ***************\n", iTestResult.getName().trim());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
        logger.info("Tests report HTML file created at extent-reports/calc-test-report.html");
    }
}
