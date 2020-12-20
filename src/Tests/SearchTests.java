package Tests;

import lib.CoreTestsCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestsCase
{
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
//    public void testAmountOfNotEmptySearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        String search_line = "Linkin Park Diskography";
//        SearchPageObject.typeSearchLine(search_line);
//        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
//
//        assertTrue(
//                "We found too few results",
//                amount_of_search_results > 0
//        );
//    }
//
//    @Test
//    public void testAmountOfEmptySearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        String search_line = "zxcvasdfqwer";
//        SearchPageObject.typeSearchLine(search_line);
//        SearchPageObject.waitForEmptyResultsLabel();
//        SearchPageObject.assertThereIsNoResultOfSearch();
//    }
//
//    @Test
//    public void testEachSearchResult() throws Exception {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//
//        SearchPageObject.checkSearchInputInEachElement("Java");
//    }

    @Test
    public void testSearchResultByTitleAndDescription() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        SearchPageObject.waitForElementByTitleAndDescription("Java", "Island of Indonesia");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "Programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }
}