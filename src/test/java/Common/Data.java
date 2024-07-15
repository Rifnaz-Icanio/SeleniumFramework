package Common;

import java.io.IOException;
import Helper.DataInputProvider;
import Helper.GlobalProperties;
import org.testng.annotations.DataProvider;

public class Data {
    public static class Common {
        public static final String testDataPath     = System.getProperty("user.dir") + "/src/test/resources/data/TestData";
        public static final String StackDataSheet   = "Stack";
        public static final String contentTypeDataSheet = "ContentType";
        public static final String sparkReportPath  = System.getProperty("user.dir") + "/test-output/SparkReport/TestReport.html";
        public static final String extentConfig     = System.getProperty("user.dir") + "/src/test/resources/extent-config.xml";
    }

    public static Object[][] getInputData(String sheetName) throws IOException {
        DataInputProvider excelDataDrivenFramework = new DataInputProvider (
                Data.Common.testDataPath + "_" + GlobalProperties.getPropertyFileValue("environment") + ".xlsx");
        int totalRows = excelDataDrivenFramework.getRowCount(sheetName);
        int totalCols = excelDataDrivenFramework.getCellCount(sheetName, 1);
        String[][] contentTypeData = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                contentTypeData[i - 1][j] = excelDataDrivenFramework.getCellData(sheetName, i, j);
            }
        }
        return contentTypeData;
    }

    @DataProvider(name = "StackData")
    public static Object[][] getStackData() throws IOException {
        return getInputData(Data.Common.StackDataSheet);
    }

    @DataProvider(name = "contentTypeData")
    public static Object[][] getContentTypeData() throws IOException {
        return getInputData(Data.Common.contentTypeDataSheet);
    }
}