package cucumbersteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.LoginSteps;

public class Login {
    @Steps
    LoginSteps login;


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