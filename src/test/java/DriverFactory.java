

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by amandac on 12/15/2016.
 */
public class DriverFactory {
    private String iEdriver = "D:\\driver\\t\\IEDriverServer.exe";
    private WebDriver driver;
    private String path;

    @BeforeSuite
    public void Setup() {
        // Uses firefox driver by default
        System.setProperty ("webdriver.ie.driver", iEdriver);
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer ( );
        ieCapabilities.setCapability (
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);
        driver = new InternetExplorerDriver (ieCapabilities);
        path = "https://www.google.com/";
    }

    @Step("Driver start")
    public void DriverFactory() {
        driver.get (path);
    }

}
