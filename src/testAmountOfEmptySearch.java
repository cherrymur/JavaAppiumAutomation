import lib.CoreTestsCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class testAmountOfEmptySearch extends CoreTestsCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSwipeArticleTitle() throws Exception {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        String name_of_article = "zxcvasdfqwer";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(name_of_article);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_text']/*[@resource-id='org.wikipedia:id/results_text']";
        String empty_result_label = "//*[@text='No results']";

        MainPageObject.waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request " + name_of_article,
                15);

        MainPageObject.assertElementNotPresent(
                By.xpath(search_result_locator),
                "We've find some results by the request '" + name_of_article + "'"
        );

        protected void tearDown throws Exception
        {
            super.tearDown();

            MainPageObject = new MainPageObject(driver);
        }
    }
}