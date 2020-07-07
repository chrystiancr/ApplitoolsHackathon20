package com.chrystian.v1.ModernTestsV1;

import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import com.chrystian.ModernApproachBaseTest;
import com.chrystian.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ModernVisualTestsV1 extends ModernApproachBaseTest {

    @Test(priority = 1)
    public void testCrossDeviceElements() {
        setEyesTestConfig("Task 1");
        driver = openEyesV1(driver);

        eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));
    }

    @Test(priority = 2)
    public void testShoppingExperience() {
        setEyesTestConfig("Task 2");
        driver = openEyesV1(driver);
        homePage = new HomePage(driver);

        homePage.getBlackColorOption().click();
        homePage.getFilterButton().click();

        eyes.check("Filter Results", Target.region(By.id("product_grid")));
    }

    @Test(priority = 3)
    public void testProductDetails() {
        setEyesTestConfig("Task 3");
        driver = openEyesV1(driver);
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

    private WebDriver openEyesV1(WebDriver webDriver) {
        webDriver = eyes.open(webDriver);
        webDriver.get(appURLV1);
        return webDriver;
    }
}