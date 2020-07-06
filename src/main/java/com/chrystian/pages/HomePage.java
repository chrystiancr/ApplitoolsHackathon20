package com.chrystian.pages;

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

    @FindBy(id = "A____217")
    private WebElement blackShoesItem;

    @FindBy(id = "product_1")
    private WebElement blackShoesItem2;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}