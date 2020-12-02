import lib.CoreTestsCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;

public class FirstTest extends CoreTestsCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

//    @Test
//    public void testSearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.waitForSearchResults("Object-oriented programming language");
//    }
//
//    @Test
//    public void testCancelSearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.waitForCancelButtonToAppear();
//        SearchPageObject.clickCancelSearch();
//        SearchPageObject.waitForCancelButtonToDisappear();
//    }
//
//    @Test
//    public void testCompareArticleTitle() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//
//        String article_title = ArticlePageObject.getArticleTitle();
//
//        Assert.assertEquals(
//                "We see unexpected title!",
//                "Java (programming language)",
//                article_title
//        );
//    }
//
//    @Test
//    public void testSwipeArticle() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Appium");
//        SearchPageObject.clickByArticleWithSubstring("Appium");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        ArticlePageObject.waitForTitleElement();
//        ArticlePageObject.swipeToFooter();
//    }
//
//    @Test
//    public void testSaveFirstArticleToMyList() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Appium");
//        SearchPageObject.clickByArticleWithSubstring("Appium");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        ArticlePageObject.waitForTitleElement();
//
//        String article_title = ArticlePageObject.getArticleTitle();
//        String name_of_folder = "My list";
//
//        ArticlePageObject.addArticleToMyList(name_of_folder);
//        ArticlePageObject.closeArticle();
//
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.OpenMyLists();
//
//        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
//        MyListsPageObject.openFolderByName(name_of_folder);
//        MyListsPageObject.swipeByArticleToDelete(article_title);
//    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() throws Exception
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_before_landscape_rotation = ArticlePageObject.getArticleTitle();

        this.screenRotateLandscape();

        String title_after_landscape_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been changed after landscape screen rotation",
                title_before_landscape_rotation,
                title_after_landscape_rotation
        );

        this.screenRotatePORTRAIT();

        String title_after_portrait_rotation = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "Article title have been changed after portrait screen rotation",
                title_before_landscape_rotation,
                title_after_portrait_rotation);
    }

    @Test
    public void testChangeSearchArticleInBackround() throws Exception {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResults("Object-oriented programming language");

        this.runAppInBackground(20);

        SearchPageObject.waitForSearchResults("Object-oriented programming language");
    }

    protected void tearDown () throws Exception
    {
        super.tearDown();

        MainPageObject = new MainPageObject(driver);
    }
}


