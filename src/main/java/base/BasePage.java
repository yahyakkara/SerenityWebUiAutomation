package base;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends PageObject {

    public WebElementFacade getElement(String locator) {
        try {
            return find(getBy(locator));
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return null;
    }

    public List<WebElementFacade> getElements(String locator) {
        try {
            return findAll(getBy(locator));
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return null;
    }

    public void click(String locator) {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
    }

    public void type(String locator, String value) {
        waitFor(getElement(locator)).type(value);
    }

    public String getText(String locator) {
        return waitFor(getElement(locator)).getText();
    }

    public String getAttributeValue(String locator, String attributeName) {
        return waitFor(getElement(locator)).getAttribute(attributeName);
    }

    public void mouseMovement(String locator) {
        WebElement moveTo = waitFor(getElement(locator));
        withAction().moveToElement(moveTo).perform();
    }

    public void assertTextEquals(String locator, String expectedText) {
        String actualText = getText(locator);
        Assert.assertEquals(actualText + " and " + expectedText + "texts are not equal!",
                actualText, expectedText);
    }

    public Boolean isElementDisplay(String locator) {
        return getElement(locator).isPresent();
    }

    public void assertTrue(boolean expected, String message){
        Assert.assertTrue(message,expected);
    }

    private By getBy(String locator) {
        By by = null;

        try {
            if (locator.startsWith("id=")) {
                locator = locator.substring(3);
                by = By.id(locator);
            } else if (locator.startsWith("xpath=")) {
                locator = locator.substring(6);
                by = By.xpath(locator);
            } else if (locator.startsWith("css=")) {
                locator = locator.substring(4);
                by = By.cssSelector(locator);
            } else if (locator.startsWith("name=")) {
                locator = locator.substring(5);
                by = By.name(locator);
            } else if (locator.startsWith("link=")) {
                locator = locator.substring(5);
                by = By.linkText(locator);
            }
            return by;
        } catch (Throwable t) {
            t.getMessage();
        }
        return null;
    }
}
