package base;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void refreshPage(){
        sleep(1000);
        getDriver().navigate().refresh();
    }

    public void click(String locator) {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(getBy(locator))).click();
    }

    public void type(String locator, String value) {
        waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(getBy(locator))).sendKeys(value);
    }

    public String getText(String locator) {
        return waitFor(getElement(locator)).getText();
    }

    public String getAttributeValue(String locator, String attributeName) {
        return waitFor(getElement(locator)).getAttribute(attributeName);
    }

    public void mouseMovement(String locator) {
        //WebElement moveTo = waitFor(getElement(locator));
        withAction().moveToElement(find(getBy(locator))).perform();
    }

    public void assertTextEquals(String locator, String expectedText) {
        WebElement element = waitFor(getElement(locator));
        String actualText =   waitForCondition().until(ExpectedConditions.presenceOfElementLocated(getBy(locator))).getText();
        Assert.assertEquals(actualText + " and " + expectedText + " texts are not equal!",
                actualText, expectedText);
    }

    public Boolean isElementDisplay(String locator) {
        return getElement(locator).isPresent();
    }

    public void assertTrue(boolean expected, String message) {
        Assert.assertTrue(message, expected);
    }

    public String getPageUrl() {
        return getDriver().getCurrentUrl();
    }

    public void navigateSelectedUrl(String url) {
        openAt(url);
    }

    public String getUrlStatus(String url) {
        StopWatch watch = new StopWatch();
        String status;
        if (!url.isEmpty()) {
            try {
                sleep(1000);
                watch.start();
                final String GET_RESPONSE_CODE_SCRIPT =
                        "var xhr = new XMLHttpRequest();" +
                                "xhr.open('GET', arguments[0], false);" +
                                "xhr.send(null);" +
                                "return xhr.status";
                status = evaluateJavascript(GET_RESPONSE_CODE_SCRIPT, url).toString();
            } finally {
                watch.stop();
            }
            return status + " Load time :" + watch.toString();
        }
        return "Url Null!";
    }

    public void scrollToEndOfPage() {
        getDriver().manage().window().fullscreen();
        evaluateJavascript("window.scrollBy(0,1000)");
    }

    public void attachDataToReportFromFile(String path, String title) {
        Path generatedReport = Paths.get(path);

        try {
            Serenity.recordReportData().withTitle(title)
                    .downloadable().fromFile(generatedReport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
