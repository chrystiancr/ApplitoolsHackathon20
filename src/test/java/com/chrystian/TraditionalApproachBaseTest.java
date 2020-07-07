package com.chrystian;

import com.chrystian.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TraditionalApproachBaseTest {
    protected String appURLV1 = "https://demo.applitools.com/gridHackathonV1.html";
    protected String appURLV2 = "https://demo.applitools.com/gridHackathonV2.html";
    protected WebDriver driver;
    protected HomePage homePage;
    protected SoftAssert softAssertions;
    private String browserName;
    private String viewport;
    private String device;
    private Dimension dimension;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        driver = setUpBrowserDriver(browser);
        softAssertions = new SoftAssert();
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    protected void setBrowserViewportLaptopSize() {
        dimension = new Dimension(1200, 700);
        driver.manage().window().setSize(dimension);
        viewport = "1200 x 700";
        device = "Laptop";
    }

    protected void setBrowserViewportTabletSize() {
        dimension = new Dimension(768, 700);
        driver.manage().window().setSize(dimension);
        viewport = "768 x 700";
        device = "Tablet";
    }

    protected void setBrowserViewportMobileSize() {
        viewport = "500 x 700";
        device = "Mobile";
    }

    protected WebDriver setUpBrowserDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setBrowserViewportLaptopSize();
            browserName = "chrome";
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setBrowserViewportLaptopSize();
            browserName = "firefox";
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            setBrowserViewportLaptopSize();
            browserName = "edge";
        } else if (browser.equalsIgnoreCase("chrome-tablet")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setBrowserViewportTabletSize();
            browserName = "chrome";
        } else if (browser.equalsIgnoreCase("firefox-tablet")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setBrowserViewportTabletSize();
            browserName = "firefox";
        } else if (browser.equalsIgnoreCase("edgechromium-tablet")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            setBrowserViewportTabletSize();
            browserName = "edge";
        } else if (browser.equalsIgnoreCase("chrome-iphonex")) {
            WebDriverManager.chromedriver().setup();
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
            setBrowserViewportMobileSize();
            browserName = "chrome";
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public boolean hackathonReporter(String version, int task, String testName, String domId, boolean comparisonResult) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Traditional-" + version + "-TestResults.txt", true))) {
            writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browserName
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        return comparisonResult;
    }

}