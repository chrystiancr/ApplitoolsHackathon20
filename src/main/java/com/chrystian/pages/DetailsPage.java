package com.chrystian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailsPage extends PageObjectBase {
    @FindBy(id = "SMALL____84")
    private WebElement productCode;

    @FindBy(xpath = "//div[@class='nice-select wide']//span")
    private WebElement size;

    @FindBy(id = "new_price")
    private WebElement itemPrice;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductCode() {
        return waiter.until(ExpectedConditions.visibilityOf(productCode));
    }

    public WebElement getSize() {
        return waiter.until(ExpectedConditions.visibilityOf(size));
    }

    public WebElement getItemPrice() {
        return waiter.until(ExpectedConditions.visibilityOf(itemPrice));
    }
}