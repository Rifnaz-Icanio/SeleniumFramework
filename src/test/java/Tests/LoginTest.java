package Tests;

import Helper.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import PageManager.PageObjectManager;
import java.io.IOException;
import static Helper.GlobalProperties.*;

public class LoginTest
{
    PageObjectManager pom = new PageObjectManager();

    @BeforeSuite
    public void initDriver() throws IOException
    {
        SeleniumHelper.initializeDriver();
        driver.manage().window().maximize();
        SeleniumHelper.initializeExtentReport();
        driver.get(getPropertyFileValue("ContentStack_LoginURL"));
    }
    @Test(priority = 0)
    public void doLogIn() throws IOException
    {
        Assert.assertEquals(getPropertyFileValue("ContentStack_LoginURL"), driver.getCurrentUrl(),"Successfully Navigated to the Content stack url");
        pom.loginUser().setEmail();
        pom.loginUser().setPassword();
        pom.loginUser().clickLoginBtn();
    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
