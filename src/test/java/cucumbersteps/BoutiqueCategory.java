package cucumbersteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.thucydides.core.annotations.Steps;
import steps.BoutiqueCategorySteps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BoutiqueCategory {
    @Steps
    BoutiqueCategorySteps boutiqueCategorySteps;

    @When("user is listed all Boutique on {string} with {string}")
    public void user_is_listed_all_boutique(String url, String pageCount) {
        String pageUrl = "https://www.trendyol.com/" + url + "?pi=" + pageCount;
        boutiqueCategorySteps.navigateToPageWithAllBoutique(pageUrl);
    }

    @Then("user update Boutique information in a file {string}{string}")
    public void user_update_boutique_information_in_a_file(String fileName, String pCount) {
        String browserName = RemoteDriver.of(getDriver()).getCapabilities().getBrowserName();
        String fitFileName = fileName.replaceAll("butik/liste/", "");
        boutiqueCategorySteps.saveBoutiqueInformation(browserName + "-" + fitFileName, pCount);
    }
}
