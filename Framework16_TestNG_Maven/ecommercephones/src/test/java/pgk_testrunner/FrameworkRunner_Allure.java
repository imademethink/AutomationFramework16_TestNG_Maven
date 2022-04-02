package pgk_testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features   = {"src/test/resources/features"},
        glue       = {
                "pkg_stepdefinition",
                "pkg_hooks"
        },
        strict     = true,
        monochrome = false,
        tags        = {"@search_special_1"},
        plugin 		= {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber/cucumber.json",
        }
)

public class FrameworkRunner_Allure extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setupBeforeClass() {
    // empty
    }

    @AfterClass
    public static void teardownAfterClass() {
    // empty
    }
}


//  Allure reporting is two Step running process
//      mvn clean test
//      mvn site

