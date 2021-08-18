package by.yaroslavTolstik.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class Driver {
    private static WebDriver driver;
    private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver62-63.exe";


    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
