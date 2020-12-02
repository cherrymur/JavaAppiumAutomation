package Tests;

import lib.CoreTestsCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestsCase
{
    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_before_landscape_rotation = ArticlePageObject.getArticleTitle();

        this.screenRotateLandscape();

        String title_after_landscape_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after landscape screen rotation",
                title_before_landscape_rotation,
                title_after_landscape_rotation
        );

        this.screenRotatePORTRAIT();

        String title_after_portrait_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after portrait screen rotation",
                title_before_landscape_rotation,
                title_after_portrait_rotation);
    }

    @Test
    public void testChangeSearchArticleInBackround()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResults("Object-oriented programming language");

        this.runAppInBackground(20);

        SearchPageObject.waitForSearchResults("Object-oriented programming language");
    }
}
