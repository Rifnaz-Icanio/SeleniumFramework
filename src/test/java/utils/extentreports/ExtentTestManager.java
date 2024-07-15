package utils.extentreports;

import Helper.GlobalProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	static ExtentReports extent = ExtentManager.createExtentReports();

	public static synchronized ExtentTest getTest() {
		ExtentTest extentTest =  extentTestMap.get((int) Thread.currentThread().getId());
		if(extentTest == null) {
			extentTest = ExtentTestManager.startTest(" ", " ");
		}
        return extentTest;	
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest extentTest = extent.createTest(testName, desc);
		GlobalProperties.etSuite = extentTest;

		extentTestMap.put((int) Thread.currentThread().getId(), extentTest);
		return extentTest;
	}
}