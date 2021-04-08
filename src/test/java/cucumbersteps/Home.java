package cucumbersteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("user is listed all Boutique on {string} with {string}")
    public void user_is_listed_all_boutique_on_home_page(String url, String pageCount) {
        String pageUrl = "https://www.trendyol.com/" + url + "?pi=" + pageCount;
        home.navigateToPageWithAllBoutique(pageUrl);
    }

    @Then("user update Boutique information in a file {string}{string}")
    public void user_update_boutique_information_in_a_file(String fileName, String pCount) {
        String fitFileName = fileName.replaceAll("/butik/liste/","");
        home.saveBoutiqueInformation(fitFileName, pCount);
    }
}
