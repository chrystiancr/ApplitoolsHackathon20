package com.chrystian;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.chrystian.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.applitools.eyes.selenium.BrowserType.*;
import static com.applitools.eyes.visualgrid.model.DeviceName.iPhone_X;
import static com.applitools.eyes.visualgrid.model.ScreenOrientation.PORTRAIT;

public class ModernApproachBaseTest {
    private static final int VIEWPORTWIDTH = 800;
    private static final int VIEWPORTHEIGHT = 600;
    private final String applitoolsEyesServer = "https://eyes.applitools.com/";
    private String appName = "AppliFashion";
    public String appURLV1 = "https://demo.applitools.com/gridHackathonV1.html";
    public String appURLV2 = "https://demo.applitools.com/gridHackathonV2.html";
    private final String batchName = "ApplitoolsCrossBrowserTestingHackathon";
    private final String apiKey = System.getenv("APPLITOOLS_API_KEY");
    private EyesRunner runner;
    private Configuration suiteConfig;
    protected Eyes eyes;
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        runner = new VisualGridRunner(10);
        suiteConfig = (Configuration) new Configuration()
                .addBrowser(1200, 700, CHROME)
                .addBrowser(1200, 700, FIREFOX)
                .addBrowser(1200, 700, EDGE_CHROMIUM)
                .addBrowser(768, 700, CHROME)
                .addBrowser(768, 700, FIREFOX)
                .addBrowser(768, 700, EDGE_CHROMIUM)
                .addDeviceEmulation(iPhone_X, PORTRAIT)
                .setViewportSize(new RectangleSize(VIEWPORTWIDTH, VIEWPORTHEIGHT))
                .setApiKey(apiKey)
                .setServerUrl(applitoolsEyesServer)
                .setAppName(appName)
                .setBatch(new BatchInfo(batchName));
    }

    @BeforeMethod
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        eyes = new Eyes(runner);
        eyes.setConfiguration(suiteConfig);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() != ITestResult.FAILURE) {
            eyes.closeAsync();
        } else {
            eyes.abortAsync();
        }
        driver.quit();
    }

    @AfterSuite
    public void results(ITestContext testContext) {
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        allTestResults.forEach(result -> handleTestResults(result));
//        for (TestResultContainer result : allTestResults) {
//            handleTestResults(result);
//        }
    }

    private void handleTestResults(TestResultContainer summary) {
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
}