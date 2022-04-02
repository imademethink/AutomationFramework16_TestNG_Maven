package com.flipcart.perfumes.pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features   = {"src/test/resources/features"},
        glue       = {
                "com.flipcart.perfumes.pkg_stepdefinition",
                "com.flipcart.perfumes.com.pkg_hooks"
        },
        strict     = true,
        monochrome = false,
//        tags        = {"~@other"},
        tags        = {"@search"},
//        tags        = {"@search,@registration"},    // OR operation
//        tags        = {"@search","@search_valid"},  // AND operation
        plugin 		= {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber/cucumber.json"
        }
)

public class FrameworkRunner_Tag extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass()
    public void setupBeforeClass() {
        // empty
    }

    @AfterClass()
    public void teardownAfterClass() {
        // empty
    }

}


//  Cucumber tag for test filtering, multiple tag ( AND, OR, NOT operation)
//  Masterthought reporting using plugin in pom.xml

