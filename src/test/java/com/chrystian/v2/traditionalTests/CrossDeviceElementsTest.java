package TraditionalTestsV2;

import TraditionalTestsV1.BaseTest;
import org.testng.annotations.Test;

public class CrossDeviceElementsTest extends BaseTest {

    String result;

    @Test(priority = 0)
    public void testSearchFieldIsDisplayed() {
        driver.get(appURLV2);
        String searchField = "DIV__customsear__41";
        boolean actualResult = homePage.isSearchFieldDisplayed();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "Search field is not displayed", searchField, result);
        } else {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "Search field is displayed", searchField, result);
        }
    }

    @Test(priority = 1)
    public void testMainMenuIsDisplayed() {
        driver.get(appURLV2);
        String mainMenu = "DIV__mainmenu__15";
        boolean actualResult = homePage.isMainMenuDisplayed();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "Menu is not displayed", mainMenu, result);
        } else {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "Menu is displayed", mainMenu, result);
        }
    }

    @Test(priority = 2)
    public void testSearchIconIsDisplayed() {
        driver.get(appURLV2);
        String searchIcon = "A__btnsearchm__59";
        boolean actualResult = homePage.isSearchIconDisplayed();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "search icon is displayed", searchIcon, result);
        } else {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "search icon is not displayed", searchIcon, result);
        }
    }

    @Test(priority = 3)
    public void testWishListIconIsDisplayed() {
        driver.get(appURLV2);
        String wishListIcon = "A__wishlist__52";
        boolean actualResult = homePage.isWishListIconDisplayed();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "Wish list icon is not displayed", wishListIcon, result);
        } else {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "wish list icon is displayed", wishListIcon, result);
        }
    }

    @Test(priority = 4)
    public void testGridIconIsDisplayed() {
        driver.get(appURLV2);
        String gridIcon = "I__tiviewgrid__203";
        boolean actualResult = homePage.isGridIconDisplayedV2();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "Grid icon is not displayed", gridIcon, result);
        } else {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "Grid icon is displayed", gridIcon, result);
        }
    }

    @Test(priority = 5)
    public void testViewListIconIsDisplayed() {
        driver.get(appURLV2);
        String viewListIcon = "I__tiviewlist__205";
        boolean actualResult = homePage.isViewListIconDisplayedV2();
        if (device.contentEquals("Mobile") || device.contentEquals("Tablet")) {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "View list icon is not displayed", viewListIcon, result);
        } else {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "View list icon is displayed", viewListIcon, result);
        }
    }

    @Test(priority = 6)
    public void testFilterColumnIsDisplayed() {
        driver.get(appURLV2);
        String filterColumn = "filter_col";
        boolean actualResult = homePage.isFilterColumnDisplayed();
        if (device.contentEquals("Laptop")) {
            if (actualResult) {
                result = "Pass";
            } else {
                result = "Fail";
            }
            hackathonReporterV2(1, "Filter column is displayed", filterColumn, result);
        } else {
            if (actualResult) {
                result = "Fail";
            } else {
                result = "Pass";
            }
            hackathonReporterV2(1, "Filter column is not displayed", filterColumn, result);
        }
    }
}