package cucumbersteps;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;

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
}
