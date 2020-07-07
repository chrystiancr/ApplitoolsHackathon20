package com.chrystian.v1.TraditionalTestsV1;

import com.chrystian.TraditionalApproachBaseTest;
import com.chrystian.pages.DetailsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TraditionalTest extends TraditionalApproachBaseTest {
    private static final String VERSION = "V1";

    @BeforeMethod
    public void setTestUp() {
        driver.get(appURLV1);
    }

    @Test(priority = 1)
    public void testHomePageElementsVisibility() {
        String searchField = "DIV__customsear__41";
        String searchIcon = "BUTTONsubmit____43";
        String mainMenu = "DIV__mainmenu__15";
        String wishListIcon = "A__wishlist__52";
        String gridIcon = "I__tiviewgrid__202";
        String viewListIcon = "I__tiviewlist__204";
        String filterColumn = "filter_col";

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Search field is displayed", searchField,
                homePage.getSearchField().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Search icon is displayed", searchIcon,
                homePage.getSearchIcon().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Main menu is displayed", mainMenu,
                homePage.getMainMenuButton().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Wish list is displayed", wishListIcon,
                homePage.getWishListIcon().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Grid icon is displayed", gridIcon,
                homePage.getGridIcon().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "View list is displayed", viewListIcon,
                homePage.getViewListIcon().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 1, "Filters column is displayed", filterColumn,
                homePage.getFilterColumn().isDisplayed()));

        softAssertions.assertAll();
    }

    @Test(priority = 2)
    public void testShoppingExperience() {
        String productGrid = "#product_grid .grid_item";

        homePage.getBlackColorOption().click();
        homePage.getFilterButton().click();

        assertTrue(hackathonReporter(VERSION, 2, "Product grid should display two items",
                productGrid, homePage.getProductGrid().size() == 2));
    }

    @Test(priority = 3)
    public void testDesiredItemDescription() {
        String productCode = "SMALL____84";
        String size = "//div[@class='nice-select wide']//span";
        String itemPrice = "new_price";

        homePage.getBlackColorOption().click();
        homePage.getFilterButton().click();
        DetailsPage detailsPage = homePage.getShoesDetail();

        softAssertions.assertTrue(hackathonReporter(VERSION, 3, "Product code is displayed", productCode,
                detailsPage.getProductCode().isDisplayed()));

        softAssertions.assertTrue(hackathonReporter(VERSION, 3, "Item size value is selected as Small (S)", size,
                detailsPage.getSize().getText().contains("S")));

        softAssertions.assertTrue(hackathonReporter(VERSION, 3, "Item price value should be $33.00", itemPrice,
                detailsPage.getItemPrice().getText().contains("$33.00")));

        softAssertions.assertAll();
    }
}