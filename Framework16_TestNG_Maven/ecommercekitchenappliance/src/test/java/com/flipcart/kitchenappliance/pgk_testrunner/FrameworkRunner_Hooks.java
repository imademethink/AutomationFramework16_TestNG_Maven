package com.flipcart.kitchenappliance.pgk_testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
   features   = {"src/test/resources/features"},
   glue       = {
           "com.flipcart.kitchenappliance.pkg_stepdefinition",
           "com.flipcart.kitchenappliance.pkg_hooks"
   },
   strict     = true,
   monochrome = false,
   tags       = {"@search_special_1"},
   plugin     = {"html:target2/fw_hooks"}
)

public class FrameworkRunner_Hooks extends AbstractTestNGCucumberTests
{

}

//  10. Cucumber hooks before after  -- Need to add additional package in glue where hooks are implemented
//          hooks for every scenario

