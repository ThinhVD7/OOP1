package Core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class BasePage {
    private static final int TIME_OUT = 500;
    private static final int POLLING=100;
    int PAGELOAD = 30;
//    Duration TIME_OUT = Duration.ofSeconds(5);
//    Duration POLLING = Duration.ofSeconds(100);
//
//    Duration PAGELOAD = Duration.ofSeconds(30);

    protected WebDriver driver;
    public WebDriverWait wait;

    String time = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, TIME_OUT, POLLING);
        PageFactory.initElements(driver, this);
    }


    public void pageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, PAGELOAD);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }


    public void scrollTo(WebElement webelement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webelement);
    }


    public void createFileandWrite(String file){

        String fileName ="MarketOverview-" +time + ".csv";
        try {
            File myObj = new File(System.getProperty("user.dir") + "\\" + fileName);
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Write File
        try {
            FileWriter myWriter = new FileWriter(System.getProperty("user.dir") + "\\" + fileName,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(file);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkFile(){
        String fileName ="MarketOverview-" +time + ".csv";
        try {
            File myObj = new File(System.getProperty("user.dir") + "\\" + fileName);
            if (myObj.createNewFile()) {
            } else {
                System.out.println("File report location is : " + System.getProperty("user.dir") + "\\" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToWebsite(String url) {
        driver.navigate().to(url);
        pageLoaded();
        maximizeBrowser();
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public void typeTo(WebElement webElement , String wordType){
        scrollTo(webElement);
        webElement.sendKeys(wordType);
    }


    public void waitDisplay(WebElement webElement, long timeOutSecond){
        WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickTo(WebElement elementToClick) {
        scrollTo(elementToClick);
        elementToClick.click();

    }
    public void
    waitAndCheckClick(WebElement webElement, long timeOutSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSecond);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void switchToChildWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWin = driver.getTitle();
            if (currentWin.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void wait(int milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
