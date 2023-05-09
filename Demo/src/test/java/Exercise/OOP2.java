package Exercise;

import Page.resultPage;
import Page.searchPage;
import base.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OOP2 extends BaseTest {
    searchPage pageSearch;
    resultPage pageResult;

    @BeforeSuite
    public void setupSuite() {
        this.pageSearch = new searchPage(driver);
        this.pageResult = new resultPage(driver);
    }

    @Test
    public void testGoogleSearch() {
        this.pageSearch.navigateToWebsite("http://google.com");
        this.pageSearch.enterSearchQuery("Selenium");
        this.pageSearch.clickGoogleSearchButton();
        this.pageResult.isSearchResultsPageDisplayed();
    }
}
