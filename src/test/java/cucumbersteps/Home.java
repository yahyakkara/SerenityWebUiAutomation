package cucumbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Home {

    @Steps
    HomeSteps home;

    @Then("user is displayed home page")
    public void user_is_displayed_home_page() {
        home.checkHomeIsOpen();
    }

    @Then("user is seen his name on the login menu {string}")
    public void user_is_seen_his_name_on_the_login_menu_something(String nameAndSurname) throws Throwable {
        home.checkUserName(nameAndSurname);
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        home.navigate();
    }

    @When("user clicks on Sign in button from header")
    public void user_clicks_on_sign_in_button_from_header() {
        home.navigateToLoginPage();
    }

    @Given("Boutique url's status code Test result is created")
    public void boutique_url_s_status_code_test_result_is_created() {
    }

    @Then("tester reads Boutique status and permormance information")
    public void test_read_boutique_status_and_permormance_information() {
    }

    @Then("Boutique status should be {int}")
    public void boutique_status_should_be(Integer int1) {
    }

    @Then("Boutique performance should be valid")
    public void boutique_performance_should_be_valid() {
    }
}