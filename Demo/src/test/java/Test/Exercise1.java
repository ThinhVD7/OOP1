package Test;

import base.BaseTest;
import Page.Bursa;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Exercise1 extends BaseTest {
    Bursa page;
    String URL = "https://www.bursamalaysia.com/";
    @BeforeSuite
    public void setupSuite() {
        page = new Bursa(driver);
    }
//    @Test (description = "get daily top 10 counter - Navigate and make sure website loaded",priority=1)
//    public void LoadPage() {
//        page.navigateToWebsite(URL);
//    }
//
//    @Test (description = "get daily top 10 counter - Scroll to Table",priority=2)
//    public void GoToTable() {
//        page.goToTable();
//    }
//
//    @Test (description = "get daily top 10 counter - Print the table to console log and output to File",priority=3)
//    public void PrintDataOut() {
//        System.out.println("The table is : \n");
//        page.getData();
//        page.sortTable("change");
//        page.printData();
//    }
@Test()
public void TC007_TestIframe() {
        page.navigateToWebsite("https://demoqa.com/frames");

    String xpathText = "//*[@id=\"XXXXXXXX\"]";

//     WebElement element = fluentWaitAndGetElement(xpathText);

 WebElement element = waitForAndGetElement(xpathText);
    String text = element.getText();

//    boolean iChecked = Utils.verifyContain(text, "This is a sample page");

    Assert.assertTrue(text.toString().equals("This is a sample page"));

    driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);

    ((JavascriptExecutor) driver).executeScript("myScript");

}

    public WebElement fluentWaitAndGetElement(Object locator) {

        int timeOut = 10;

        int pollingTime = 200;

        final By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());

        WebElement we = null;



        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))

                .pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);

        we = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver webDriver) {

                return webDriver.findElement(by);

            }

        });

        return we;

    }



    public WebElement waitForAndGetElement(Object locator, int... opParams) {

        int timeOut = opParams.length > 0 ? opParams[0] : 5;

        int pollingTime = 500;



        final By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());

        WebElement we = null;



        try {

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))

                    .pollingEvery(Duration.ofMillis(pollingTime));

            we = wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver webDriver) {

                    return webDriver.findElement(by);

                }

            });

            if (we != null) {

                return we;

            }

        } catch (NoSuchElementException e) {

        }

        return null;

    }

}

