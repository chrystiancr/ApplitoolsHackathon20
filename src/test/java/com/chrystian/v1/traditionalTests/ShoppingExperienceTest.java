import org.testng.annotations.Test;

public class ShoppingExperienceTest extends BaseTest {

    String result;

    @Test
    public void testShoppingExperience() {
        driver.get(appURLV1);
        String productGrid = "#product_grid .grid_item";
        homePage.isCheckboxElementDisplayed();
        homePage.checkBlackColorOption();
        homePage.clickFilterButton();
        boolean actualResult = homePage.product_Grid_Should_Contain_2_Items();
        if (actualResult) {
            result = "Pass";
        } else {
            result = "Fail";
        }
        hackathonReporterV1(2, "Product grid should display two items",
                productGrid, result);
    }
}
