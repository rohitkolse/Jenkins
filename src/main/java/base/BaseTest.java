package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        WebDriver webDriver = DriverFactory.initDriver(browser);
        driver.set(webDriver);

        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getProperty("url"));

        System.out.println("Running on browser: " + browser);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}