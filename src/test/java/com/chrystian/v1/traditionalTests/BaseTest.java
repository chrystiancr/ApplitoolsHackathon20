package TraditionalTestsV1;

import com.chrystian.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public String browserName;
    public String viewport;
    public String device;
    protected String appURLV1 = "https://demo.applitools.com/gridHackathonV1.html";
    protected String appURLV2 = "https://demo.applitools.com/gridHackathonV2.html";

    protected WebDriver driver;
    protected HomePage homePage;
    private Dimension dimension;

    @Parameters("browser")
    @BeforeMethod
    public void launchBrowser(String browser) {
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
        } else if (browser.equalsIgnoreCase("edgechromium")) {
            System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
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
            System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }

    public void setBrowserViewportLaptopSize() {
        dimension = new Dimension(1200, 700);
        driver.manage().window().setSize(dimension);
        viewport = "1200 x 700";
        device = "Laptop";
    }

    public void setBrowserViewportTabletSize() {
        dimension = new Dimension(768, 700);
        driver.manage().window().setSize(dimension);
        viewport = "768 x 700";
        device = "Tablet";
    }

    public void setBrowserViewportMobileSize() {
        viewport = "500 x 700";
        device = "Mobile";
    }

    /**
     * @param task
     * @param testName
     * @param domId
     * @param Result
     */
    protected void hackathonReporterV1(int task, String testName, String domId, String Result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))) {
            writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browserName
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: "
                    + Result);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing report to the file");
        }
    }

    /**
     * @param task
     * @param testName
     * @param domId
     * @param Result
     */
    protected String hackathonReporterV2(int task, String testName, String domId, String Result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Traditional-V2-TestResults.txt", true))) {
            writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browserName
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: "
                    + Result);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing report to the file");
        }
        return Result;
    }
}