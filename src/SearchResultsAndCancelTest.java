import org.junit.Test;
import org.openqa.selenium.By;

public class SearchResultsAndCancelTest extends TestClass {

    @Test
    public void testSearchResultsAndCancel() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search field",
                5);

        this.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_display']"),
                "There is no list with results",
                5);

        this.waitForElementAndClear(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"),
                "Cannot find search field",
                5);

        this.waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_display']"),
                "There is a list with results",
                5);

        this.tearDown();
    }
}