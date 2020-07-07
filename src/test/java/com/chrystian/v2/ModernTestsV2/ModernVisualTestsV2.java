package com.chrystian.v2.ModernTestsV2;

import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import com.chrystian.ModernApproachBaseTest;
import com.chrystian.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ModernVisualTestsV2 extends ModernApproachBaseTest {

    @Test(priority = 1)
    public void testCrossDeviceElements() {
        setEyesTestConfig("Task 1");
        driver = openEyesV2(driver);

        eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
    }

    @Test(priority = 2)
    public void testShoppingExperience() {
        setEyesTestConfig("Task 2");
        driver = openEyesV2(driver);
        homePage = new HomePage(driver);

        homePage.getBlackColorOption().click();
        homePage.getFilterButton().click();

        eyes.check("Filter Results", Target.region(By.id("product_grid")));
    }

    @Test(priority = 3)
    public void testProductDetails() {
        setEyesTestConfig("Task 3");
        driver = openEyesV2(driver);
        homePage = new HomePage(driver);

        homePage.getBlackColorOption().click();
        homePage.getFilterButton().click();
        homePage.getFirstBlackShoesItem().click();

        eyes.check(Target.window().fully().withName("Product Details test"));
    }

    private void setEyesTestConfig(String taskName) {
        Configuration testConfig = eyes.getConfiguration();
        testConfig.setTestName(taskName);
        eyes.setConfiguration(testConfig);
    }

    private WebDriver openEyesV2(WebDriver webDriver) {
        webDriver = eyes.open(webDriver);
        webDriver.get(appURLV2);
        return webDriver;
    }
}