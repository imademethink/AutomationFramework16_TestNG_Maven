package pkg_hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Hooks_Simple extends GlobalObjects{
    private static final Logger myLog = Logger.getLogger(Hooks_Simple.class);

    @Before
    public void beforeEachScenario(){
        myLog.info("Log: Before every Scenario");
        String sChromeBinary=System.getProperty("user.dir") + "\\src\\test\\resources\\browserDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sChromeBinary);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        // Disable image loading - to speedup test execution
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.images", 2);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);

        GlobalDriver = new ChromeDriver(options);

        myLog.info("Log: Navigating to " + sUrlSearch + "\n");
        GlobalDriver.get(sUrlSearch);
        GlobalDriver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @After
    public void afterEachScenario(){
        myLog.info("Log: After the every Scenario" + "\n");
        GlobalDriver.quit();
    }

//    @After
//    public void afterEachScenarioWithScreenShot(Scenario scenario){
//        myLog.info("Log: After the every Scenario" + "\n");
//
//        // Add screenshot only if scenario fails
//        if (scenario.isFailed()) {
//            String sDDMMYY = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//            File src       = ((TakesScreenshot) GlobalDriver).getScreenshotAs(OutputType.FILE);
//            String dest    = System.getProperty("user.dir") +
//                             "//target//cucumber-extent-reports//"+"screenshot_"+sDDMMYY+".jpg";
//            File finalDestination = new File(dest);
//
//            try {
//                FileUtils.copyFile(src, finalDestination);
//                Reporter.addScreenCaptureFromPath(finalDestination.getAbsolutePath());
//            }catch (IOException eScreenshot) {
//                eScreenshot.printStackTrace();
//            }
//        }
//        GlobalDriver.quit();
//    }
//

}
