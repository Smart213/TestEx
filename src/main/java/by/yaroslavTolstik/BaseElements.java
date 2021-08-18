package by.yaroslavTolstik;

import by.yaroslavTolstik.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseElements {

    public static WebElement getClickableElement(String field) {
        return new WebDriverWait(Driver.getDriver(), 5, 1000)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(field)));
    }

    public static WebElement getVisibilityElement(String field) {
        return new WebDriverWait(Driver.getDriver(), 7, 1000)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(field)));
    }

    public static boolean isOpen(String locator) {
        return new WebDriverWait(Driver.getDriver(), 20, 100)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).isDisplayed();
    }

    public static boolean isAttribute(String locator, String attr, String val) {
        return new WebDriverWait(Driver.getDriver(), 20, 100)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).getAttribute(attr).contains(val);
    }

    public static boolean isDisplayed(String field) {
        return new WebDriverWait(Driver.getDriver(), 7, 1000)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(field))).isDisplayed();
    }

    public static boolean isVisible(String field) {
        return !$$(field).isEmpty();
    }

    public static List<WebElement> $$(String field) {
        return Driver.getDriver().findElements(By.cssSelector(field));
    }
}
