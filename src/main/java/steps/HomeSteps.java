package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
    HomePage home;
    LoginPage loginPage;

    @Step("Navigating to www.trendyol.com website homePage")
    public HomeSteps navigate() {
        home.open();
        home.closeFancyBoxIfDisplayed();
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

    @Step("Opening selected boutique page with all boutique")
    public void navigateToPageWithAllBoutique(String url) {
        String fitUrl;

        if (url.contains("Home")) {
            fitUrl = url.replace("Home", "");
        } else {
            fitUrl = url;
        }
        home.navigateSelectedUrl(fitUrl);
    }


    @Step("Checking Boutique reliability and saving in a file")
    public void saveBoutiqueInformation(String fileName, String pCount) {
        home.getAllBoutiquesUrlBasicInfo();
        home.getAllBoutiquesUrlImageUrl(pCount);
        home.saveBoutiqueInformationToFile(fileName);
        String currentWorkingDir = System.getProperty("user.dir");
        home.attachDataToReportFromFile(currentWorkingDir+"/"+fileName+"Information.csv",fileName+".CSV");
    }

}
