package pages;

import Utils.CsvUtils;
import base.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    String userInitialIcon = "css=i[class='i-user initial-icon']";
    String loginButton = "css=.login-button";
    String fancyBoxClose = "css=a[title='Close']";
    String userName = "css=.user-name";
    String browsingHomePage = "css=#browsing-gw-homepage";
    String boutiqueContainer = "css=article[class='component-item'] a";
    String boutiqueImage = "css=article[class='component-item'] span[class='image-container'] img";
    String boutiqueUrlAttribute = "href";
    String boutiqueIdAttribute = "data-id";


    public void moveToUserInitialIcon() {
        mouseMovement(userInitialIcon);
    }


    public void clickToLoginButton() {
        moveToUserInitialIcon();
        sleep(1000);
        click(loginButton);
    }

    public void closeFancyBoxIfDisplayed() {
        if (isElementDisplay(fancyBoxClose)) {
            click(fancyBoxClose);
            System.out.println("Clik");
        }
    }

    public void checkUserName(String nameAndSurname) {
        assertTextEquals(userName, nameAndSurname);
    }

    public void verifyHomePageOpen() {
        boolean isHomePageOpen = waitFor(getElement(browsingHomePage)).isDisplayed();
        assertTrue(isHomePageOpen, "Home screen should be opened");
    }
}