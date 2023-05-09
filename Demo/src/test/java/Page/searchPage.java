package Page;

import Core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends BasePage {
    @FindBy(
            name = "q"
    )
    private WebElement searchBox;
    @FindBy(
            name = "btnK"
    )
    private WebElement googleSearchButton;

    public searchPage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        this.waitDisplay(this.searchBox, 60L);
        this.typeTo(this.searchBox, query);
    }

    public void clickGoogleSearchButton() {
        this.waitAndCheckClick(this.googleSearchButton, 60L);
        this.clickTo(this.googleSearchButton);
    }
}
