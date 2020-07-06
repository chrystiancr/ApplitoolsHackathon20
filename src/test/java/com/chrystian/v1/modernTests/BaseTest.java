package ModernTestsV1;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final int VIEWPORTWIDTH = 800;
    private static final int VIEWPORTHEIGHT = 600;
    private final String applitoolsEyesServer = "https://eyes.applitools.com/";
    String appName = "AppliFashion";
    public String appURLV1 = "https://demo.applitools.com/gridHackathonV1.html";
    public String appURLV2 = "https://demo.applitools.com/gridHackathonV2.html";
    private final String batchName = "ApplitoolsCrossBrowserTestingHackathon";
    private final String apiKey = System.getenv("APPLITOOLS_API_KEY");
    private EyesRunner runner = null;
    private Configuration suiteConfig;
    protected Eyes eyes;
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        runner = new VisualGridRunner(10);
        suiteConfig = (Configuration) new Configuration()
                .addBrowser(1200, 700, BrowserType.CHROME)
                .addBrowser(1200, 700, BrowserType.FIREFOX)
                .addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM)
                .addBrowser(768, 700, BrowserType.CHROME)
                .addBrowser(768, 700, BrowserType.FIREFOX)
                .addBrowser(768, 700, BrowserType.EDGE_CHROMIUM)
                .addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT)
                .setViewportSize(new RectangleSize(VIEWPORTWIDTH, VIEWPORTHEIGHT))
                .setApiKey(apiKey)
                .setServerUrl(applitoolsEyesServer)
                .setAppName(appName)
                .setBatch(new BatchInfo(batchName));
    }

    @BeforeMethod
    public void launchBrowser() {
        eyes = new Eyes(runner);
        eyes.setConfiguration(suiteConfig);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitDriver(ITestResult result) {
        boolean testFailed = result.getStatus() == ITestResult.FAILURE;
        if (!testFailed) {
            eyes.closeAsync();
        } else {
            eyes.abortAsync();
        }
        driver.quit();
    }

    @AfterSuite
    public void results(ITestContext testContext) {
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        for (TestResultContainer result : allTestResults) {
            handleTestResults(result);
        }
    }

    public void handleTestResults(TestResultContainer summary) {
        Throwable ex = summary.getException();
        if (ex != null) {
            System.out.printf("System error occurred while checking target.\n");
        }
        TestResults result = summary.getTestResults();
        if (result == null) {
            System.out.printf("No test results information available\n");
        } else {
            System.out.printf("URL = %s, AppName = %s, testname = %s, Browser = %s,OS = %s, viewport = %dx%d, " +
                            "matched = %d,mismatched = %d, missing = %d,aborted = %s\n",
                    result.getUrl(),
                    result.getAppName(),
                    result.getName(),
                    result.getHostApp(),
                    result.getHostOS(),
                    result.getHostDisplaySize().getWidth(),
                    result.getHostDisplaySize().getHeight(),
                    result.getMatches(),
                    result.getMismatches(),
                    result.getMissing(),
                    (result.isAborted() ? "aborted" : "no"));
        }
    }

    public void isCheckboxElementDisplayed() {
        WebElement blackColorCheckBox = driver.findElement(By.cssSelector("#LABEL__containerc__104 span"));
        if (!blackColorCheckBox.isDisplayed()) {
            driver.findElement(By.id("ti-filter")).click();
        } else {
            System.out.println("checkbox element is displayed");
        }
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}