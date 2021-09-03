package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import pom.CalcElements;

/**
 * Created by yardenmorshtein on 03/09/2021.
 */
public class BaseTests {

    protected WebDriver driver;
    protected CalcElements calcActions;
    protected static ExtentReports extentReports;


    @BeforeClass
    public void beforeClass()  {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://web2.0calc.com/");
        calcActions = new CalcElements(driver);
        createExtentReports();
    }

    public static ExtentReports createExtentReports() {
        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/calc-test-report.html");
        reporter.config().setReportName("Calculator Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company Name", "Talkspace");
        extentReports.setSystemInfo("Author", "Yarden Morshtein");
        return extentReports;
    }
}
