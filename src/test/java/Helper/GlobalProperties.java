package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class GlobalProperties
{

    public static ExtentReports extentReports;

    public static ExtentTest etSuite;

    public static ExtentTest etTest, etLog;

    public static WebDriver driver;

    @Getter
    public static HashMap<String, String> inputJsonValue;

    public enum waitType
    {
        fluent, explicit,
    }
    public enum expectedConditions
    {
        elementToBeClickable, presenceOfElementLocated, visibilityOfAllElementsLocated
    }
    public WebDriver getDriver()
    {
        return driver;
    }
    public static String getprojectpath()
    {
        String path = System.getProperty("user.dir");
        return path;
    }
    public static String getPropertyFileValue(String key) throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream(getprojectpath() + "/src/test/resources/data/data.properties"));
        Object object = properties.get(key);
        String value = (String) object;
        return value;
    }
}

