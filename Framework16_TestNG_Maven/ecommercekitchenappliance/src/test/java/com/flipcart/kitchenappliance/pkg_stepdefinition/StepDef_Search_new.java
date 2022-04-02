package com.flipcart.kitchenappliance.pkg_stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.flipcart.kitchenappliance.pkg_hooks.GlobalObjects;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class StepDef_Search_new extends GlobalObjects {
    private static final Logger myLog = Logger.getLogger(StepDef_Search_new.class);

    @Test
    @When("^User attempts to search for \"(.*?)\" ecommerce item$")
    public void User_attempts_to_search_for_item_ecommerce(String sSearchType) {
        myLog.info("Log: Searching for " + sSearchType + " items");
        String sSearchItem = "dress";
        if (sSearchType.toLowerCase().contains("invalid")) {
            sSearchItem = "candle";
        }
        GlobalDriver.findElement(By.id("search_query_top")).sendKeys(sSearchItem);
        GlobalDriver.findElement(By.name("submit_search")).click();
        GlobalDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    @Then("^Successful ecommerce search results \"(.*?)\" shown")
    public void Successful_ecommerce_search_results_shown(String sExpectedSearchResult) {
        String sResultCount = GlobalDriver.findElement(By.cssSelector("span[class='heading-counter']")).getText();

        if (sExpectedSearchResult.contains("should NOT be") &&
                sResultCount.contains("0 results have been found")) {
            myLog.info("Log: Item search criteria met");
            return;
        }


        if (sExpectedSearchResult.contains("should be") &&
                sResultCount.contains("7 results have been found")) {
            myLog.info("Log: Item search criteria met");
            return;
        }

        Assert.fail("Log: Item search criteria NOT met");
    }

    @Test
    @When("^Dummy$")
    public void Dummy() {
        myLog.info("Dummy");
    }

}