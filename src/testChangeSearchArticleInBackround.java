//import org.junit.Test;
//import org.openqa.selenium.By;
//
//public class testChangeSearchArticleInBackround {
//
//    @Test
//    public void ChangeSearchArticleInBackroundTest() throws Exception {
//        this.setUp();
//
//        this.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
//        String name_of_article = "Java";
//
//        this.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                name_of_article,
//                "Cannot find search field",
//                5);
//
//        String article_description = "Object-oriented programming language";
//        this.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
//                        "[@text='" + article_description + "']"),
//                "Cannot find '" + article_description + "' topic searching by " + name_of_article,
//                15);
//
//        this.runAppInBackground();
//        this.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
//                        "[@text='" + article_description + "']"),
//                "Cannot find '" + name_of_article + "' after returning from background ",
//                15);
//
//        this.tearDown();
//    }
//}