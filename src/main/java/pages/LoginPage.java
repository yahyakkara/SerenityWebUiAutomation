package pages;

import base.BasePage;

public class LoginPage extends BasePage {
    String emailInput = "id=login-email";
    String passwordInput = "id=login-password-input";
    String submitButton = "css=button[type='submit']";
    String passwordEyeButton = "css=i[class*='i-eye-']";
    String errorMessage = "css=#error-box-wrapper > span.message";
    String welcomeText = "css=.lr-title h3";

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void submit() {
        click(submitButton);
    }

    public LoginPage clickPasswordEye() {
        click(passwordEyeButton);
        return this;
    }

    public void validatePasswordIsVisible() {
        String passWordType = getAttributeValue(passwordInput, "type");
        assertTrue(passWordType.equalsIgnoreCase("text"), "Password input Type should be text");
    }

    public void validateErrorMessage(String expectedText) {
        assertTextEquals(errorMessage, expectedText);
    }

    public void verifyLoginPageIsOpen() {
        String expectedWelcomeText = "Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!";
        assertTextEquals(welcomeText, expectedWelcomeText);
    }
}
