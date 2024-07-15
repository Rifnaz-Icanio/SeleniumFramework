package Tests;
import Common.Data;
import org.testng.annotations.Test;
import java.io.IOException;
import PageManager.*;

public class StackTest
{
    PageObjectManager pom = new PageObjectManager();
    @Test(priority = 1,dataProvider = "StackData", dataProviderClass = Data.class)
    public void clickStack(String stackName,String stackDescription) throws IOException
    {
        pom.stackView().CreateNewStack();
        pom.stackView().stackDetails(stackName,stackDescription);
        pom.stackView().clickCreate();
    }
}
