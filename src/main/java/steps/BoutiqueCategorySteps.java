package steps;

import net.thucydides.core.annotations.Step;
import pages.BoutiqueCategoryPage;

public class BoutiqueCategorySteps {
    BoutiqueCategoryPage boutiqueCategoryPage;

    @Step("Opening selected boutique page with all boutique")
    public void navigateToPageWithAllBoutique(String url) {
        String fitUrl;

        if (url.contains("Home")) {
            fitUrl = url.replace("Home", "");
        } else {
            fitUrl = url;
        }
        boutiqueCategoryPage.navigateSelectedUrl(fitUrl);
    }

    @Step("Checking Boutique reliability and saving in a file")
    public void saveBoutiqueInformation(String fileName, String pCount) {
        boutiqueCategoryPage.getAllBoutiquesUrlBasicInfo();
        boutiqueCategoryPage.getAllBoutiquesUrlImageUrl(pCount);
        boutiqueCategoryPage.saveBoutiqueInformationToFile(fileName);
        String currentWorkingDir = System.getProperty("user.dir");
        boutiqueCategoryPage.attachDataToReportFromFile(currentWorkingDir+"/"+fileName+"Information.csv",fileName+".csv");
    }
}
