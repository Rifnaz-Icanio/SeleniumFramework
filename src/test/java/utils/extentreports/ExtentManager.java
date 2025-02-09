package utils.extentreports;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager  {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		String reportFileName = "Automation Test Report";
		String reportPath = System.getProperty("user.dir") + "/test-output/" + getCurrentDate();
		File dir = new File(reportPath);
		if (!dir.exists())
			dir.mkdir();
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				reportPath + "/ExtentReport/ExtentReports_" + getCurrentDateTime() + "/TestReport.html");
		reporter.config().setReportName(reportFileName);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle(reportFileName);
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName(reportFileName);
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		reporter.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
				ViewName.AUTHOR, ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG }).apply();
		try {
			reporter.loadXMLConfig("extent-config.xml");

		} catch (IOException e) {

			e.printStackTrace();
		}
		extentReports.attachReporter(reporter);
		extentReports.setAnalysisStrategy(AnalysisStrategy.SUITE);
		extentReports.setSystemInfo("Author", "Arafath Rifnas");
		return extentReports;
	}

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
