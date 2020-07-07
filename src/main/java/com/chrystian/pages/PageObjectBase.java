package com.chrystian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectBase {

    protected WebDriver driver;
    protected WebDriverWait waiter;

    public PageObjectBase(WebDriver pageDriver) {
        driver = pageDriver;
        waiter = new WebDriverWait(driver, 15);
        waiter.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }
}