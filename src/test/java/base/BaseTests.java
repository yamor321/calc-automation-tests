package base;

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

    @BeforeClass
    public void beforeClass()  {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://web2.0calc.com/");
        calcActions = new CalcElements(driver);
    }


}
