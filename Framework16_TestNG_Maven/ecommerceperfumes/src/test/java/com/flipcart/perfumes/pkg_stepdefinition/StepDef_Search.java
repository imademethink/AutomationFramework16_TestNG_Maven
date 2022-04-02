package com.flipcart.perfumes.pkg_stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class StepDef_Search {

    WebDriver Driver     = null;
    String    sUrlSearch = "http://automationpractice.com/index.php";
    private static final Logger myLog = Logger.getLogger(StepDef_Search.class);

    @Test
    @Given("^User navigates to search screen$")
    public void User_navigates_to_search_screen(){
        String sChromeBinary=System.getProperty("user.dir") + "\\src\\test\\resources\\browserDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sChromeBinary);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);

        Driver = new ChromeDriver(options);

        myLog.info("Log: Navigating to " + sUrlSearch);
        Driver.get(sUrlSearch);
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Test
    @When("^User attempts to search for \"(.*?)\" item$")
    public void User_attempts_to_search_for_item(String sSearchType){
        myLog.info("Log: Searching for " + sSearchType + " items");
        String sSearchItem = "dress";
        if(sSearchType.toLowerCase().contains("invalid")){
            sSearchItem = "candle";
        }
        Driver.findElement(By.id("search_query_top")).sendKeys(sSearchItem);
        Driver.findElement(By.name("submit_search")).click();
        Driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    @Then("^Successful search results \"(.*?)\" shown")
    public void Successful_search_results_shown(String sExpectedSearchResult){
        String sResultCount = Driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();
        Driver.quit();

        if(sExpectedSearchResult.contains("should NOT be") &&
           sResultCount.contains("0 results have been found"))
        {
            myLog.info("Log: Item search criteria met");
            return;
        }


        if(sExpectedSearchResult.contains("should be") &&
           sResultCount.contains("7 results have been found"))
        {
            myLog.info("Log: Item search criteria met");
            return;
        }

        Assert.fail("Log: Item search criteria NOT met");
    }


}