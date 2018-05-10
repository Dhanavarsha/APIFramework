package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.utils.ExceptionUtil;
import org.sqlite.date.ExceptionUtils;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter {
    private ExtentReports extentReports;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extentReports = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extentReports.flush();
        extentReports.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extentReports.startTest(result.getMethod().getMethodName());
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));
                test.assignCategory("Functional");
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                String message = status.toString().toUpperCase();

                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();

                test.log(status,message);

                extentReports.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}