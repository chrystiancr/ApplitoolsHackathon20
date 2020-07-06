package ModernTestsV1;

import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ModernVisualTestsV1 extends BaseTest {

    @Test(priority = 0)
    public void testCrossDeviceElements() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 1");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(appURLV1);
        eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
    }

    @Test(priority = 1)
    public void testShoppingExperience() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 2");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(appURLV1);
        isCheckboxElementDisplayed();
        WebElement checkBox = driver.findElement(By.cssSelector("#LABEL__containerc__104 span"));
        waitForElementToBeDisplayed(checkBox);
        checkBox.click();
        WebElement filterButton = driver.findElement(By.id("filterBtn"));
        waitForElementToBeDisplayed(filterButton);
        filterButton.click();
        eyes.check("Filter Results", Target.region(By.cssSelector("#DIV__collg__186 #product_grid")));
    }

    @Test(priority = 2)
    public void testProductDetails() {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName("Task 3");
        eyes.setConfiguration(testConfig);
        driver = eyes.open(driver);
        driver.get(appURLV1);
        isCheckboxElementDisplayed();
        WebElement checkBox = driver.findElement(By.cssSelector("#LABEL__containerc__104 span"));
        waitForElementToBeDisplayed(checkBox);
        checkBox.click();
        WebElement filterButton = driver.findElement(By.id("filterBtn"));
        waitForElementToBeDisplayed(filterButton);
        filterButton.click();
        WebElement item = driver.findElement(By.id("A____217"));
        waitForElementToBeDisplayed(item);
        item.click();
        eyes.check(Target.window().fully().withName("Product Details test"));
    }
}