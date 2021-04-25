package pages;

import base.BasePage;

public class HomePage extends BasePage {
    String userInitialIcon = "css=i[class='i-user initial-icon']";
    String loginButton = "css=.login-button";
    String fancyBoxClose = "css=a[title='Close']";
    String userName = "css=.user-name";
    String browsingHomePage = "css=#browsing-gw-homepage";

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