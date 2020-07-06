package TraditionalTestsV2;

import TraditionalTestsV1.BaseTest;
import com.chrystian.pages.DetailsPage;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    String result;

    @Test(priority = 0)
    public void testItemModelDescriptionValueIsDisplayed() {
        driver.get(appURLV2);
        String itemModelDesc = "SMALL____84";
        homePage.isCheckboxElementDisplayed();
        homePage.checkBlackColorOption();
        homePage.clickFilterButton();
        DetailsPage detailsPage = homePage.clickBlackShoeItem1V2();
        boolean actualResult = detailsPage.itemModelDescriptionIsDisplayed();
        if (actualResult) {
            result = "Pass";
        } else {
            result = "Fail";
        }
        hackathonReporterV2(3, "Item model description text is displayed", itemModelDesc, result);
    }

    @Test(priority = 1)
    public void testSizeSmallIsDisplayed() {
        driver.get(appURLV2);
        String size = "//div[@class='nice-select wide']//span";
        homePage.isCheckboxElementDisplayed();
        homePage.checkBlackColorOption();
        homePage.clickFilterButton();
        DetailsPage detailsPage = homePage.clickBlackShoeItem1V2();
        boolean actualResult = detailsPage.sizeSmallIsDisplayed();
        if (actualResult) {
            result = "Pass";
        } else {
            result = "Fail";
        }
        hackathonReporterV2(3, "Item size value is selected as Small (S)", size, result);
    }

    @Test(priority = 2)
    public void testCorrectItemPriceValueIsDisplayed() {
        driver.get(appURLV2);
        String itemPrice = "new_price";
        homePage.isCheckboxElementDisplayed();
        homePage.checkBlackColorOption();
        homePage.clickFilterButton();
        DetailsPage detailsPage = homePage.clickBlackShoeItem1V2();
        boolean actualResult = detailsPage.itemPriceValue();
        if (actualResult) {
            result = "Pass";
        } else {
            result = "Fail";
        }
        hackathonReporterV2(3, "Item price value should be $33.00", itemPrice, result);
    }
}