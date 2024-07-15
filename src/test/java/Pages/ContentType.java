package Pages;
import Common.Attributes;
import Helper.GlobalProperties;
import Helper.SeleniumHelper;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContentType
{
    @FindBy(how = How.XPATH, using = Attributes.ContentType.contentType)
    private WebElement elm_contentType;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.newContentType)
    private WebElement elm_newContentType;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.createNew)
    private WebElement elm_createNew;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.contentTypeName)
    private WebElement elm_contentTypeName;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.uID)
    private WebElement elm_UID;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.description)
    private WebElement elm_description;

    @FindBy(how = How.XPATH, using = Attributes.ContentType.saveProceed)
    private WebElement elm_saveProceed;

    public ContentType()
    {
        PageFactory.initElements(GlobalProperties.driver, this);
        GlobalProperties.etSuite = GlobalProperties.extentReports.createTest("Content Type");
    }

    public void navigateContentType() {
        GlobalProperties.etTest = GlobalProperties.etSuite.createNode("Create New content type");

        elm_contentType = SeleniumHelper.waitForElement(Attributes.ContentType.contentType, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_contentType != null && elm_contentType.isDisplayed())
        {
            Assert.assertTrue(elm_contentType.isDisplayed(), "Content Type module is present or displayed");
            elm_contentType.click();
            GlobalProperties.etTest.log(Status.INFO, "Content type module is clicked");
        }
        else
        {
            Assert.assertEquals("content type module is not displayed", false);
            GlobalProperties.etTest.log(Status.INFO, "content type module is not clicked");
        }
    }

        public void createNewContentType()
        {
            elm_newContentType = SeleniumHelper.waitForElement(Attributes.ContentType.newContentType, GlobalProperties.waitType.explicit,
                    GlobalProperties.expectedConditions.visibilityOfAllElementsLocated, 120, 2);

            if (elm_newContentType != null && elm_newContentType.isDisplayed())
            {
                Assert.assertTrue(elm_newContentType.isDisplayed(), "New content type button is present or displayed");
                elm_newContentType.click();
                GlobalProperties.etTest.log(Status.INFO, "New content type button is clicked");
            }
            else
            {
                Assert.assertEquals("New content type is not displayed", false);
                GlobalProperties.etTest.log(Status.INFO, "New content type button is not clicked");
            }
            elm_createNew = SeleniumHelper.waitForElement(Attributes.ContentType.createNew, GlobalProperties.waitType.explicit,
                    GlobalProperties.expectedConditions.visibilityOfAllElementsLocated, 60, 2);

            if (elm_createNew != null && elm_createNew.isDisplayed())
            {

                Assert.assertTrue(elm_createNew.isDisplayed(), "Create New button is present or displayed");
                elm_createNew.click();
                GlobalProperties.etTest.log(Status.INFO, "Create New button is clicked");
            }
            else
            {
                Assert.assertEquals("Create New is not displayed", false);
                GlobalProperties.etTest.log(Status.INFO, "Create New button is not clicked");
            }
    }

    public void contentTypeDetails(String contentName,String contentUid, String contentDescription)
    {
        elm_contentTypeName = SeleniumHelper.waitForElement(Attributes.ContentType.contentTypeName, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_contentTypeName != null && elm_contentTypeName.isDisplayed())
        {
            Assert.assertTrue(elm_contentTypeName.isDisplayed(), "Content type Name field is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "Content type Name field is present or displayed");
            SeleniumHelper.setText(elm_contentTypeName, contentName);
            GlobalProperties.etTest.log(Status.INFO, "Given content Type Name :"+contentName+" is entered");
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_contentTypeName != null && elm_contentTypeName.isDisplayed();
            Assert.assertEquals("Content type Name field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
            GlobalProperties.etTest.log(Status.INFO, "content type Name field is not displayed");
        }

        elm_UID = SeleniumHelper.waitForElement(Attributes.ContentType.uID, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_UID != null && elm_UID.isDisplayed())
        {
            Assert.assertTrue(elm_UID.isDisplayed(), "UID field is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "UID field is present or displayed");
            SeleniumHelper.setText(elm_UID, contentUid);
            GlobalProperties.etTest.log(Status.INFO, "Given UID :"+ contentUid +" is entered");
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_UID != null && elm_UID.isDisplayed();
            Assert.assertEquals("UID field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
            GlobalProperties.etTest.log(Status.INFO, "UID field is not displayed");
        }

        elm_description = SeleniumHelper.waitForElement(Attributes.ContentType.description, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_description != null && elm_description.isDisplayed())
        {

            Assert.assertTrue(elm_description.isDisplayed(), "Content type description field is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "Content type description field is present or displayed");
            SeleniumHelper.setText(elm_description, contentDescription);
            GlobalProperties.etTest.log(Status.INFO, "Given Content type Description :"+ contentDescription +" is entered");
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_description != null && elm_description.isDisplayed();
            Assert.assertEquals("content type description field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
            GlobalProperties.etTest.log(Status.INFO, "Stack description field is not displayed");
        }
    }
    public void clickSaveProceed()
    {
        elm_saveProceed = SeleniumHelper.waitForElement(Attributes.ContentType.saveProceed, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.visibilityOfAllElementsLocated, 120, 2);

        if (elm_saveProceed != null && elm_saveProceed.isDisplayed()) {

            Assert.assertTrue(elm_saveProceed.isDisplayed(), "Save and Proceed button is present or displayed");
            elm_saveProceed.click();
            GlobalProperties.etTest.log(Status.INFO, "Save and Proceed button is clicked");
        }
        else
        {
            Assert.assertEquals("save and proceed Button is not displayed", false);
            GlobalProperties.etTest.log(Status.INFO, "save and proceed button is not displayed");
        }
    }
}
