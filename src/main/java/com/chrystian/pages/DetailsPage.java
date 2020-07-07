package com.chrystian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends PageObject {
    @FindBy(id = "SMALL____84")
    private WebElement itemModelDescription;

    @FindBy(xpath = "//div[@class='nice-select wide']//span")
    private WebElement size;

    @FindBy(id = "new_price")
    private WebElement itemPrice;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }
}