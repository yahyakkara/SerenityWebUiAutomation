package cucumbersteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.thucydides.core.annotations.Steps;
import steps.BoutiqueListSteps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BoutiqueCategoryList {
    @Steps
    BoutiqueListSteps boutiqueListSteps;

    @When("user is listed all Boutique on {string} with {string}")
    public void user_is_listed_all_boutique_on_home_page(String url, String pageCount) {
        String pageUrl = "https://www.trendyol.com/" + url + "?pi=" + pageCount;
        boutiqueListSteps.navigateToPageWithAllBoutique(pageUrl);
    }

    @Then("user update Boutique information in a file {string}{string}")
    public void user_update_boutique_information_in_a_file(String fileName, String pCount) {
        String browserName = RemoteDriver.of(getDriver()).getCapabilities().getBrowserName();
        String fitFileName = fileName.replaceAll("butik/liste/", "");
        boutiqueListSteps.saveBoutiqueInformation(browserName + "-" + fitFileName, pCount);
    }
}
