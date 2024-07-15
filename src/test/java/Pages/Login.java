package Pages;

import Helper.GlobalProperties;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Common.Attributes;
import Helper.GlobalProperties.expectedConditions;
import Helper.SeleniumHelper;
import Helper.GlobalProperties.waitType;
import org.testng.Assert;
import java.io.IOException;
import static Helper.GlobalProperties.getPropertyFileValue;

public class Login {

    @FindBy(how = How.XPATH, using = Attributes.Login.userName)
    private WebElement elm_userName;

    @FindBy(how = How.XPATH, using = Attributes.Login.passWord)
    private WebElement elm_password;

    @FindBy(how = How.XPATH, using = Attributes.Login.loginBtn)
    private WebElement elm_button;

    @FindBy(how = How.XPATH, using = Attributes.Login.stackVisibility)
    private WebElement elm_stackVisibility;

    public Login()
    {
        PageFactory.initElements(GlobalProperties.driver , this);
        GlobalProperties.etSuite = GlobalProperties.extentReports.createTest("Login ");
    }

    public void setEmail() throws IOException
    {
        GlobalProperties.etTest = GlobalProperties.etSuite.createNode("Login Test");

        GlobalProperties.etTest.log(Status.INFO, "URL :"+ getPropertyFileValue("ContentStack_LoginURL"));

        elm_userName = SeleniumHelper.waitForElement(Attributes.Login.userName, waitType.explicit,
                expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_userName != null && elm_userName.isDisplayed())
        {
            Assert.assertTrue(elm_userName.isDisplayed(), "Email input field is present or displayed");
            SeleniumHelper.setText(elm_userName,getPropertyFileValue("loginEmail"));
            GlobalProperties.etTest.log(Status.INFO, "Given Email Address:"+getPropertyFileValue("loginEmail") +" is Entered" );
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_userName != null && elm_userName.isDisplayed();
            GlobalProperties.etTest.log(Status.INFO, "Given Email Address:"+getPropertyFileValue("loginEmail") +" is not Entered" );
            Assert.assertEquals("Email field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
          }
    }

    public void setPassword() throws IOException
    {
        elm_password = SeleniumHelper.waitForElement(Attributes.Login.passWord, waitType.explicit,
                expectedConditions.presenceOfElementLocated, 60, 2);

        if (elm_password != null && elm_password.isDisplayed())
        {
            Assert.assertTrue(elm_password.isDisplayed(), "Password input field is present or displayed");
            SeleniumHelper.setText(elm_password, getPropertyFileValue("loginPassword"));
            GlobalProperties.etTest.log(Status.INFO, "Given Password:"+getPropertyFileValue("loginPassword") +" is Entered" );
        }
        else
        {
            boolean isEmailFieldDisplayed = elm_password != null && elm_password.isDisplayed();
            Assert.assertEquals("Password field is not displayed", false, String.valueOf(isEmailFieldDisplayed));
        }
    }

    public void clickLoginBtn()
    {
        elm_button = SeleniumHelper.waitForElement(Attributes.Login.loginBtn, waitType.explicit,
                expectedConditions.presenceOfElementLocated, 60, 2);
        GlobalProperties.etTest.log(Status.INFO, "Login button is presented"  );

        if (elm_button != null && elm_button.isDisplayed())
        {
            Assert.assertTrue(elm_button.isDisplayed(), "Login Button is present or displayed");
            GlobalProperties.etTest.log(Status.INFO, "Login button is clicked" );
            elm_button.click();

            elm_stackVisibility = SeleniumHelper.waitForElement(Attributes.Login.stackVisibility, waitType.explicit,expectedConditions.presenceOfElementLocated,60,2);

            if (elm_stackVisibility.isDisplayed())
            {
                Assert.assertTrue(true, "Login successful and Navigated to the stack");
            }
            else
            {
                Assert.fail("Login is not successful");
            }
        }
        else
        {
            Assert.assertEquals("Login Button is not displayed", false);
        }
    }
}
