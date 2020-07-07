package com.chrystian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;

    @FindBy(id = "A__btnsearchm__59")
    private WebElement searchIcon;

    @FindBy(id = "A__wishlist__52")
    private WebElement wishListIcon;

    @FindBy(id = "I__tiviewgrid__202")
    private WebElement gridIcon;

    @FindBy(id = "I__tiviewgrid__203")
    private WebElement gridIcon2;

    @FindBy(id = "I__tiviewlist__204")
    private WebElement viewListIcon;

    @FindBy(id = "I__tiviewlist__205")
    private WebElement viewListIcon2;

    @FindBy(id = "filter_col")
    private WebElement filterColumn;

    @FindBy(id = "DIV__mainmenu__15")
    private WebElement mainMenuButton;

    @FindBy(css = "#LABEL__containerc__104 span")
    private WebElement blackColorOption;

    @FindBy(id = "filterBtn")
    private WebElement filterButton;

    @FindBy(css = "#product_grid .grid_item")
    private WebElement productGrid;

    @FindBy(id = "IMG__imgfluid__215")
    private WebElement firstBlackShoesItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        return waiter.until(ExpectedConditions.visibilityOf(searchField));
    }

    public WebElement getSearchIcon() {
        return waiter.until(ExpectedConditions.visibilityOf(searchIcon));
    }

    public WebElement getWishListIcon() {
        return waiter.until(ExpectedConditions.visibilityOf(wishListIcon));
    }

    public WebElement getGridIcon() {
        return waiter.until(ExpectedConditions.visibilityOf(gridIcon));
    }

    public WebElement getViewListIcon() {
        return waiter.until(ExpectedConditions.visibilityOf(viewListIcon));
    }

    public WebElement getFilterColumn() {
        return waiter.until(ExpectedConditions.visibilityOf(filterColumn));
    }

    public WebElement getMainMenuButton() {
        return waiter.until(ExpectedConditions.visibilityOf(mainMenuButton));
    }

    public WebElement getBlackColorOption() {
        return waiter.until(ExpectedConditions.visibilityOf(blackColorOption));
    }

    public WebElement getFilterButton() {
        return waiter.until(ExpectedConditions.elementToBeClickable(filterButton));
    }

    public WebElement getProductGrid() {
        return waiter.until(ExpectedConditions.visibilityOf(productGrid));
    }

    public WebElement getFirstBlackShoesItem() {
        return waiter.until(ExpectedConditions.elementToBeClickable(firstBlackShoesItem));
    }

    public boolean checkElementsVisibility() {

        return false;
    }
}