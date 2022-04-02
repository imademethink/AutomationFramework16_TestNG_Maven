package com.flipcart.kitchenappliance.pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features   = {"src/test/resources/features"},
        glue       = {"com.flipcart.kitchenappliance.pkg_stepdefinition"},
        strict     = true,
        monochrome = false,
        tags       = {"@login_repeat_N_times"}, // without background keyword in feature file
        //tags       = {"@search"},               // with background keyword in feature file
        plugin = {
                // for normal Junit HTML reporting
                "html:target1/junit-reports",
        }
)


public class FrameworkRunner extends AbstractTestNGCucumberTests
{

}


//  7. Parameter passing in feature file
//      Single multiple, String/ number
//      For specific step - Data table (converted to HashMap)
//      For entire scenario/ Scenario-outline
//      Difference between Scenario Outline & Scenario
//      Difference between Scenario Outline & Data Table
//  9. Background keyword - limitations (after scenario not possible)
//  10. Examples without hooks


