package Helper;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Strings;
import Common.Data;
import Helper.GlobalProperties.expectedConditions;
import Helper.GlobalProperties.waitType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {
    public static void initializeDriver() throws IOException {
        String browserName = GlobalProperties.getPropertyFileValue("browser");

        if (browserName.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--proxy-server='direct://'", "--proxy-bypass-list=*");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-features=AutomaticTabCreation");
            if (GlobalProperties.getPropertyFileValue("isHeadless") == "true")
                chromeOptions.addArguments("--headless");
            GlobalProperties.driver = new ChromeDriver(chromeOptions);
        }
    }

    public static WebElement waitForElement(String xPath, waitType wType, expectedConditions expConditions, int timeOut,
                                            int pollingInterval) {
        FluentWait<WebDriver> fWait = null;
        WebDriverWait webDriverwait = null;
        WebElement element = null;
        String innerText;
        try {
            switch (wType) {
                case fluent:
                    fWait = new FluentWait<WebDriver>(GlobalProperties.driver).withTimeout(Duration.ofSeconds(timeOut))
                            .pollingEvery(Duration.ofSeconds(pollingInterval))
                            .ignoring(NoSuchElementException.class, TimeoutException.class);
                    break;
                case explicit:
                    webDriverwait = new WebDriverWait(GlobalProperties.driver, Duration.ofSeconds(timeOut));
                    break;
            }

            switch (expConditions) {
                case elementToBeClickable:
                    if (wType == waitType.fluent)
                        element = fWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                    else
                        element = webDriverwait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
                    break;
                case presenceOfElementLocated:
                    if (wType == waitType.fluent)
                        element = fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
                    else
                        element = webDriverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
                    break;
                case visibilityOfAllElementsLocated:
                    if (wType == waitType.fluent)
                        element = fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath))).get(0);
                    else
                        element = webDriverwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath))).get(0);
                    break;
            }
            innerText = Strings.isNullOrEmpty(getInnerText(element)) ? xPath : getInnerText(element);
        } catch (Exception ex) {
            element = null;
        }
        return element;
    }

    public static void setText(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception ex) {
        }
    }

    public static String getInnerText(WebElement element) {
        String text = "";
        try {
            text = element.getText();
            if (Strings.isNullOrEmpty(text)) {
                text = element.getAttribute("value");
                if (Strings.isNullOrEmpty(text)) {
                    text = element.getAttribute("innerHTML");
                }
            }
        } catch (Exception ex) {
        }
        return text;
    }

    public static void initializeExtentReport() throws IOException {
        GlobalProperties.extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(Data.Common.sparkReportPath);
        reporter.loadXMLConfig(new File(Data.Common.extentConfig));
        reporter.config().setJs("var firstElem = document.evaluate('//h6[text()='Test'] //following::div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;var text = document.evaluate('//a[@id = 'nav-test', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;firstElem.addEventListener('click', function() {text.focus();});");
        GlobalProperties.extentReports.attachReporter(reporter);
        GlobalProperties.extentReports.setAnalysisStrategy(AnalysisStrategy.SUITE);
    }
}