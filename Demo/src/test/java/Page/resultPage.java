package Page;

import Core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class resultPage extends BasePage {
    @FindBy(
            id = "search"
    )
    private WebElement searchResults;
    public resultPage(WebDriver driver) {
        super(driver);
    }
    public void isSearchResultsPageDisplayed() {
        this.waitDisplay(this.searchResults, 20L);
        Assert.assertTrue(this.searchResults.isDisplayed(), "Search Results not found");
    }
}
