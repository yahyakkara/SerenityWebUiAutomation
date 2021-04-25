package steps;

import net.thucydides.core.annotations.Step;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Step("Filling username and password")
    public void fillTheLoginInputs(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Step("Clicking 'Giris' button")
    public void clickToSubmit() {
        loginPage.submit();
    }

    @Step("Validating login error messages")
    public void validateErrorMessage(String errorMessage) {
        loginPage.validateErrorMessage(errorMessage);
    }

    @Step("Verifying login page is open")
    public void verifyLoginPage() {
        loginPage.verifyLoginPageIsOpen();
    }

    @Step("Clicking password eye button")
    public void clickPasswordEye() {
        loginPage.clickPasswordEye();
    }

    @Step("Verify password is visible")
    public void verifyPasswordVisible() {
        loginPage.validatePasswordIsVisible();
    }
}