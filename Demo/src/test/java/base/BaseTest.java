package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void beforeSuite(@Optional("chrome") String browser) throws Exception{
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            default:
                throw new Exception("Wrong driver, please set property");
        }
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

    @AfterClass
    public void afterClass () {
        driver.manage().deleteAllCookies();
    }

}
