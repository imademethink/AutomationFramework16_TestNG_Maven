package util_listener;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyITestListener implements ITestListener {
    private static final Logger myLog = Logger.getLogger(MyITestListener.class);

    public void onStart(ITestContext context) {
        myLog.info("When method started - onStart");
    }

    public void onFinish(ITestContext context) {
        myLog.info("When method finished - onFinish Passed Tests are " + context.getPassedTests());
        myLog.info("When method finished - onFinish Failed Tests are " + context.getFailedTests());
    }



    public void onTestStart(ITestResult result) {
        myLog.info("When new Test started - onTestStart " +result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        myLog.info("When new Test success - onTestSuccess " +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        myLog.info("When new Test fail - onTestFailure " +result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        myLog.info("When new Test skip - onTestSkipped " +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
