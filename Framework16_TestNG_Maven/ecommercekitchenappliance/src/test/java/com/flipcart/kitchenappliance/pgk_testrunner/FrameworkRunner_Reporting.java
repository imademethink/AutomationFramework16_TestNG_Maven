package com.flipcart.kitchenappliance.pgk_testrunner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.io.File;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features   = {"src/test/resources/features"},
        glue       = {
                "com.flipcart.kitchenappliance.pkg_stepdefinition",
                "com.flipcart.kitchenappliance.pkg_hooks"
        },
        strict     = true,
        monochrome = false,
        //tags       = {"@search_special_1"},
        tags       = {"@registration_fail"},   // with retry failure listener
        plugin = {
                "html:target/junit-reports",
                // for Extent reporting
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/extent-report.html"
        }
)

public class FrameworkRunner_Reporting extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setupBeforeClass() {
    // empty
    }

    @AfterClass
    public static void teardownAfterClass() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extent-config.xml"));
        Reporter.setSystemInfo("Environment","SIT");
        Reporter.setSystemInfo("Author","Tony Stark");
    }
}

//  Annotations - hierarchy is - Suite, Test, Class, Method
//      - BeforeClass/AfterClass - Extent Reporting
//      - BeforeSuite/AfterSuite
//      - BeforeTest/AfterTest

//      Using @DataProvider - A test method that uses @DataProvider will be executed multiple number of times
//                            based on the configuration provided in it. The test method will be executed
//                            using the same instance of the test class to which the test method belongs.

//  Listeners (are not Fixtures) (Also not present in Junit)
//    ITestListener
//    IRetryAnalyzer and IAnnotationTransformer

//  Running Parallel classes

//  Special HTML reporting - Extent HTML Reporting

//  Screenshot inside special (Extent) reporting
//      Need to add failure screenshots after every scenario (so need better implementation of @After hook)
//  AShot library advantages:
//      ashot 1.5.3, Gson 2.8.5, Hamcreast-all 1.3
//      Free, can take screenshot on Android/ iOS devices
//      Can take screenshot of individual element
//      Can Blur/ decorate screenshot, can compare screenshots




//    tags        = {"@login"},
//    tags        = {"@register"},
//    tags        = {"@search"},
//    tags        = {"@login,@register"},         // OR operation
//    tags        = {"@search","@search_valid"},  // AND operation

//  Cucumber tag for test filtering, multiple tag ( AND, OR, NOT operation)
//  BeforeSuite/AfterSuite
//  Allure reporting
//  Email sending - using another testng class
//  Page object model, Page factory
//  Remaining other utility e.g. Db, docker
//  Page Object Model
//      Object Creation - At the time of init
//                      - Need basis
//  Page Factory - WebElement storage
//                      - Same class - Page factory
//                      - Different class
//  Other Selenium Utilities
//		Sikuli - image comparison
//		Robot class - mouse click on screen e.g. close javascript popup, file upload, close google ads
//      Frame handling, pop up, window
//      Javascript -
//      Action/ Select -
//      Explicit wait




//  Test scenario writing using cucumber
//  Tag controlled scenario filtering
//  Junit based test execution
//  Command line execution
//  Maven for jar file dependency management
//  Reporting - HTML (Extent), Excel, PDF
//  Failed tests with screenshot
//  Report emailing
//  Rerun failed tests n times
//  Extent reporting with failed tests logs as well
//  Cucumber hooks implementation so each scenario can focus on actual task
//  Junit fixtures usage - for external activities e.g. docker, database, website
//  Reading data from external files properties, csv, excel, pdf
//  Core Java concepts Inheritance, Collection framework
//  Numerous utilities for file handling, selenium
//  Utility to run tests headless, without image loading for speedy execution
//  Page Object, Page factory implementation
//  Logging using Log4j
//  Browser invoking - local, remote (selenium grid)
//  Sikuli / Robot framework
//  Galenium for alignment verification


