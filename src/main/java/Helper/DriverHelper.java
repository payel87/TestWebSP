package Helper;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {

    public DriverHelper() {
    }

    public static void clearAndSendKeys(WebDriver webDriver, WebElement element, String text) {
        ((WebElement) (new WebDriverWait(webDriver, 5L)).until(ExpectedConditions.visibilityOf(element))).clear();
        element.click();
        element.sendKeys(text);
    }

    public static void waitForElementToBePresent(WebDriver webDriver, WebElement elementLocator, int timeout) {
        try {
            (new WebDriverWait(webDriver, (long) timeout)).withMessage("Element:" + webDriver.toString() + " not visible after waiting").ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementLocator));
        } catch (Exception var4) {

        }
    }
}
