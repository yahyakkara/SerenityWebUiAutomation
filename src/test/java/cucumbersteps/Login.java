package cucumbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;
import steps.LoginSteps;

public class Login {

    @Steps
    HomeSteps home;

    @Steps
    LoginSteps login;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        home.navigate();
    }

    @When("user clicks on Sign in button from header")
    public void user_clicks_on_sign_in_button_from_header() {
        home.navigateToLoginPage();
    }

    @Then("user is displayed login page")
    public void user_is_displayed_login_page() {
        login.verifyLoginPage();
    }

    @When("user enters {string} and {string}")
    public void user_enters_in_username_field(String email, String password) {
        login.fillTheLoginInputs(email, password);
    }

    @When("user clicks Sign in button")
    public void user_clicks_sign_in_button() {
        login.clickToSubmit();
    }

    @Then("user gets login failed error {string}")
    public void user_gets_login_failed_error(String errorMessage) {
        login.validateErrorMessage(errorMessage);
    }

    @When("user clicks password eye button")
    public void user_clicks_password_eye_button() {
        login.clickPasswordEye();
    }

    @Then("user can display password")
    public void user_can_display_password() {
        login.verifyPasswordVisible();
    }
}
