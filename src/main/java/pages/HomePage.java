package pages;

import Utilities.CsvHelper;
import base.BasePage;
import io.cucumber.java.sl.In;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    String userInitialIcon = "css=i[class='i-user initial-icon']";
    String loginButton = "css=div[class='login-button']";
    String fancyBoxClose = "css=a[title='Close']";
    String userName = "css=.user-name";
    String browsingHomePage = "css=#browsing-gw-homepage";
    String boutiqueContainer = "css=article[class='component-item'] a";
    String boutiqueImage = "css=article[class='component-item'] span[class='image-container'] img";
    String boutiqueUrlAttribute = "href";
    String boutiqueIdAttribute = "data-id";


    public void moveToUserInitialIcon() {
        mouseMovement(userInitialIcon);
    }

    public void clickToLoginButton() {
        click(loginButton);
    }

    public void closeFancyBoxIfDisplayed() {
        if (isElementDisplay(fancyBoxClose)) {
            click(fancyBoxClose);
        }
    }

    public void checkUserName(String nameAndSurname) {
        assertTextEquals(userName, nameAndSurname);
    }

    public void verifyHomePageOpen() {
        boolean isHomePageOpen = waitFor(getElement(browsingHomePage)).isDisplayed();
        assertTrue(isHomePageOpen, "Home screen should be opened");
    }

    public void getAllBoutiquesUrlBasicInfo() {
        List<WebElementFacade> boutiqueContainerList = getElements(boutiqueContainer);
        Serenity.setSessionVariable("boutiqueInfoList").to(boutiqueContainerList);
    }

    public void getAllBoutiquesUrlImageUrl(String pCount) {
        int count = Integer.parseInt(pCount);
        for (int i = 0; i <= count; i++) {
            scrollToEndOfPage();
        }

        List<WebElementFacade> boutiqueContainerList = getElements(boutiqueImage);
        Serenity.setSessionVariable("boutiqueImageUrlList").to(boutiqueContainerList);
    }

    public void saveBoutiqueInformationToFile(String fileName) {
        List<WebElementFacade> boutiqueInfoList = Serenity.sessionVariableCalled(
                "boutiqueInfoList");
        List<WebElementFacade> boutiqueImageList = Serenity.sessionVariableCalled(
                "boutiqueImageUrlList");

        List<String[]> recordList = new ArrayList<>();

        for (int i = 0; i < boutiqueInfoList.size(); i++) {
            WebElementFacade boutiqueInfo = boutiqueInfoList.get(i);
            WebElementFacade boutiqueImageUrl = boutiqueImageList.get(i);
            String boutiqueId = boutiqueInfo.getAttribute(boutiqueIdAttribute);
            String boutiqueName = boutiqueInfo.getText();
            String boutiqueUrl = boutiqueInfo.getAttribute(boutiqueUrlAttribute);
            String boutiqueImage = boutiqueImageUrl.getAttribute("src");
            String boutiqueStatus = getUrlStatus(boutiqueUrl);
            String imageStatus = getUrlStatus(boutiqueImage);
            String[] record = {boutiqueId, boutiqueName, boutiqueUrl, boutiqueStatus, boutiqueImage, imageStatus};
            recordList.add(record);
        }
        String[] headerList = {"Id", "Name", "Url", "Boutique Status", "Boutique Image Url", "Image Status"};
        CsvHelper.writeCsvFile(fileName + "Information.csv", headerList, recordList);
    }
}