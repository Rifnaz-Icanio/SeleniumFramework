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
import java.io.IOException;

public class Stack
{
    @FindBy(how = How.XPATH, using = Attributes.stack.newStackBtn)
    private WebElement elm_newStackBtn;

    @FindBy(how = How.XPATH, using = Attributes.stack.createNewStack)
    private WebElement elm_createNewStack;

    @FindBy(how = How.XPATH, using = Attributes.stack.stackName)
    private WebElement elm_stackName;

    @FindBy(how = How.XPATH, using = Attributes.stack.description)
    private WebElement elm_description;

    @FindBy(how = How.XPATH, using = Attributes.stack.createStackBtn)
    private WebElement elm_createStackBtn;

    @FindBy(how = How.XPATH, using = Attributes.stack.successToastMsg)
    private WebElement elm_successToastMsg;

    @FindBy(how = How.XPATH, using = Attributes.stack.dashBoard)
    private WebElement elm_dashboard;


    public Stack()
    {
        PageFactory.initElements(GlobalProperties.driver , this);
        GlobalProperties.etSuite = GlobalProperties.extentReports.createTest("Stack");
    }
    public void CreateNewStack()
    {
        GlobalProperties.etTest = GlobalProperties.etSuite.createNode("Creating New Stack");

        elm_newStackBtn = SeleniumHelper.waitForElement(Attributes.stack.newStackBtn, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_newStackBtn != null && elm_newStackBtn.isDisplayed()) {

            Assert.assertTrue(elm_newStackBtn.isDisplayed(), "New Stack button is present or displayed");
            elm_newStackBtn.click();
            GlobalProperties.etTest.log(Status.INFO, "New Stack button is clicked");
        }
        else
        {
            Assert.assertEquals("New Stack is not displayed", false);
            GlobalProperties.etTest.log(Status.INFO, "New Stack button is not clicked");
        }

    elm_createNewStack = SeleniumHelper.waitForElement(Attributes.stack.createNewStack, GlobalProperties.waitType.explicit,
    GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_createNewStack != null && elm_createNewStack.isDisplayed()) {

    Assert.assertTrue(elm_createNewStack.isDisplayed(), "Create Stack button is present or displayed");
    elm_createNewStack.click();
    GlobalProperties.etTest.log(Status.INFO, "Create Stack button is clicked");
    }
        else
    {
        Assert.assertEquals("Create Stack is not displayed", false);
        GlobalProperties.etTest.log(Status.INFO, "Create Stack button is not clicked");
    }
    }

    public void stackDetails(String stackName,String stackDescription) throws IOException
    {
        elm_stackName = SeleniumHelper.waitForElement(Attributes.stack.stackName, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_stackName != null && elm_stackName.isDisplayed())
        {
            Assert.assertTrue(elm_stackName.isDisplayed(), "Stack Name field is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "Stack Name field is present or displayed");

            SeleniumHelper.setText(elm_stackName, stackName );
            GlobalProperties.etTest.log(Status.INFO, "Given Stack Name :"+stackName+" is entered");
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_stackName != null && elm_stackName.isDisplayed();
            Assert.assertEquals("Stack Name field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
            GlobalProperties.etTest.log(Status.INFO, "Stack Name field is not displayed");
        }
        elm_description = SeleniumHelper.waitForElement(Attributes.stack.description, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_description != null && elm_description.isDisplayed())
        {

            Assert.assertTrue(elm_description.isDisplayed(), "Stack description field is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "Stack description field is present or displayed");
            SeleniumHelper.setText(elm_description, stackDescription);
            GlobalProperties.etTest.log(Status.INFO, "Given Stack Description :"+stackDescription+" is entered");
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_description != null && elm_description.isDisplayed();
            Assert.assertEquals("Stack description field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
            GlobalProperties.etTest.log(Status.INFO, "Stack description field is not displayed");
        }
    }

    public void clickCreate()
    {
        elm_createStackBtn = SeleniumHelper.waitForElement(Attributes.stack.createStackBtn, GlobalProperties.waitType.explicit,
                GlobalProperties.expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_createStackBtn != null && elm_createStackBtn.isDisplayed()) {

            Assert.assertTrue(elm_createStackBtn.isDisplayed(), "Create button is present or displayed");
            elm_createStackBtn.click();
            GlobalProperties.etTest.log(Status.INFO, "Create button is clicked");
        }
        else
        {
            Assert.assertEquals("Create Button is not displayed", false);
            GlobalProperties.etTest.log(Status.INFO, "Create button is not displayed");
        }
    }
    public void checkCreatedStack()
    {
        elm_successToastMsg = SeleniumHelper.waitForElement(Attributes.stack.successToastMsg, GlobalProperties.waitType.explicit, GlobalProperties.expectedConditions.presenceOfElementLocated,500,2);
        if (elm_successToastMsg.isDisplayed())
        {
            Assert.assertTrue(true, "Stack Created successfully toast message is displayed");
        }
        else
        {
            Assert.fail("Stack Created successfully toast message is not displayed");
        }
        elm_dashboard = SeleniumHelper.waitForElement(Attributes.stack.dashBoard, GlobalProperties.waitType.explicit, GlobalProperties.expectedConditions.presenceOfElementLocated,60,2);
        if (elm_dashboard.isDisplayed())
        {
            Assert.assertTrue(true, "Created stack is displayed in the stacks dashboard");
        }
        else
        {
            Assert.fail("Created stack is not displayed in the stacks dashboard");
        }
    }
}

