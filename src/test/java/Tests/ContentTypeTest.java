package Tests;

import Common.Data;
import PageManager.PageObjectManager;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContentTypeTest {
    PageObjectManager pom = new PageObjectManager();

    @Test(priority = 1, dataProvider = "contentTypeData", dataProviderClass = Data.class)
    public void contentDetails(String contentName, String contentUid, String contentDescription)
    {
        pom.contentView().navigateContentType();
        pom.contentView().createNewContentType();
        pom.contentView().contentTypeDetails(contentName,contentUid,contentDescription);
        pom.contentView().clickSaveProceed();
    }
}