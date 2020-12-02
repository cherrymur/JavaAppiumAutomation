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

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "My list";

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.OpenMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

//    @Test
//    public void testAmountOfNotEmptySearch() throws Exception {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        String search_line = "Linkin Park Diskography";
//        SearchPageObject.typeSearchLine(search_line);
//        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
//
//        Assert.assertTrue(
//                "We found too few results",
//                amount_of_search_results > 0
//        );
//    }
//
//    @Test
//    public void testAmountOfEmptySearch() throws Exception
//    {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        String search_line = "zxcvasdfqwer";
//        SearchPageObject.typeSearchLine(search_line);
//        SearchPageObject.waitForEmptyResultsLabel();
//        SearchPageObject.assertThereIsNoResultOfSearch();
//}
    protected void tearDown () throws Exception
    {
        super.tearDown();

        MainPageObject = new MainPageObject(driver);
    }
}


