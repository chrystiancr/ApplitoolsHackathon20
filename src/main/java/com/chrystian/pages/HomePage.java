package com.chrystian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends PageObjectBase {

    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;

    @FindBy(id = "BUTTONsubmit____43")
    private WebElement searchIcon;

    @FindBy(id = "A__wishlist__52")
    private WebElement wishListIcon;

    @FindBy(id = "I__tiviewgrid__202")
    private WebElement gridIcon;

    @FindBy(id = "I__tiviewlist__204")
    private WebElement viewListIcon;

    @FindBy(id = "filter_col")
    private WebElement filterColumn;

    @FindBy(id = "DIV__mainmenu__15")
    private WebElement mainMenuButton;

    @FindBy(id = "LABEL__containerc__104")
    private WebElement blackColorOption;

    @FindBy(id = "filterBtn")
    private WebElement filterButton;

    @FindBy(css = "#product_grid .grid_item")
    private List<WebElement> productGrid;

    @FindBy(id = "product_1")
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
        return gridIcon;
    }

    public WebElement getViewListIcon() {
        return viewListIcon;
    }

    public WebElement getFilterColumn() {
        return filterColumn;
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

    public List<WebElement> getProductGrid() {
        return waiter.until(ExpectedConditions.visibilityOfAllElements(productGrid));
    }

    public WebElement getFirstBlackShoesItem() {
        return waiter.until(ExpectedConditions.elementToBeClickable(firstBlackShoesItem));
    }

    public DetailsPage getShoesDetail() {
        getFirstBlackShoesItem().click();
        return new DetailsPage(driver);
    }

}

