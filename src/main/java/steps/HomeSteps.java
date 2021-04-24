package steps;

import net.thucydides.core.annotations.Step;
import pages.BoutiqueCategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
    HomePage home;
    LoginPage loginPage;

    @Step("Navigating to www.trendyol.com website homePage")
    public HomeSteps navigate() {
        home.open();
        home.refreshPage();
        return this;
    }

    @Step("Verifying home screen is opened")
    public void checkHomeIsOpen() {
        home.verifyHomePageOpen();
    }

    @Step("Navigating login screen")
    public LoginPage navigateToLoginPage() {
        home.clickToLoginButton();
        return loginPage;
    }

    @Step("Closing homepage-popup if is displayed")
    public void closeHomePopUp() {
        home.closeFancyBoxIfDisplayed();
    }

    @Step("Checking first name and surname on the menu")
    public void checkUserName(String nameAndSurname) {
        home.moveToUserInitialIcon();
        home.checkUserName(nameAndSurname);
    }

}