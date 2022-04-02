package com.flipcart.perfumes.pkg_stepdefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepDef_Login {

    WebDriver Driver       = null;
    String    sUrlLogin    = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String    sUrlRegister = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final Logger myLog = Logger.getLogger(StepDef_Login.class);

    @Test
    @Given("^User navigates to login screen using \"(.*?)\" browser$")
    public void User_navigates_to_login_screen(String sBrowserType){

        if(!sBrowserType.toLowerCase().equals("chrome")) {
            Assert.fail("Log: Currently only supporting chrome browser");
        }

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

        myLog.info("Log: Navigating to " + sUrlLogin);
        Driver.get(sUrlLogin);
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Test
    @When("^User attempts to login with Username \"(.*?)\" and Password \"(.*?)\"$")
    public void User_attempts_to_login_with_Username_and_Password(String sUser, String sPwd){
        myLog.info("Log: Attempting to login with valid credentials");
        Driver.findElement(By.id("email")).sendKeys(sUser);
        Driver.findElement(By.id("passwd")).sendKeys(sPwd);
        Driver.findElement(By.cssSelector("i[class='icon-lock left']")).click();
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Test
    @Then("^Login should be successful$")
    public void Login_should_be_successful(){
        boolean bLoginSuccess = false;
        if(Driver.findElements(By.cssSelector("a[title='Log me out']")).size() > 0){
            bLoginSuccess = true;
        }
        Driver.quit();

        if(bLoginSuccess){
            myLog.info("Log: Login is successful");
        }
        else{
            Assert.fail("Log: Login is NOT successful");
        }
    }




    @Test
    @Given("^User navigates to registration screen$")
    public void User_navigates_to_registration_screen(){
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

        myLog.info("Log: Navigating to " + sUrlLogin);
        Driver.get(sUrlLogin);
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }


    @Test
    @When("^User attempts to register with following data$")
    public void User_attempts_to_register_with_following_data(DataTable dtUserData){

        // Converting DataTable into hashmap
        Map<String, String> hmUserData = dtUserData.asMap(String.class, String.class);

        myLog.info("Log: Registration begins");
        Driver.findElement(By.id("email_create")).sendKeys(
                hmUserData.get("Email") + new Random().nextInt(99999) + "@mailinator.com");
        Driver.findElement(By.cssSelector("i[class*='icon-user']")).click();
        Driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

        Driver.findElement(By.id("id_gender1")).click();
        Driver.findElement(By.id("customer_firstname")).sendKeys(hmUserData.get("NameFirst"));
        Driver.findElement(By.id("customer_lastname")).sendKeys(hmUserData.get("NameLast"));
        Driver.findElement(By.id("passwd")).sendKeys(hmUserData.get("Password"));

        new Select(Driver.findElement(By.id("days"))).selectByValue(hmUserData.get("DOB_DD"));
        new Select(Driver.findElement(By.id("months"))).selectByValue(hmUserData.get("DOB_MM"));
        new Select(Driver.findElement(By.id("years"))).selectByValue(hmUserData.get("DOB_YYYY"));

        Driver.findElement(By.id("firstname")).sendKeys(hmUserData.get("AddressNameFirst"));
        Driver.findElement(By.id("lastname")).sendKeys(hmUserData.get("AddressNameLast"));
        Driver.findElement(By.id("address1")).sendKeys(hmUserData.get("Address"));
        Driver.findElement(By.id("city")).sendKeys(hmUserData.get("City"));
        new Select(Driver.findElement(By.id("id_state"))).selectByValue("15");
        Driver.findElement(By.id("postcode")).sendKeys(hmUserData.get("Zip"));

        Driver.findElement(By.id("other")).sendKeys(hmUserData.get("AdditionalInfo"));
        Driver.findElement(By.id("phone_mobile")).sendKeys(hmUserData.get("Mobile"));

        Driver.findElement(By.id("submitAccount")).click();
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Test
    @Then("^Registration should be successful$")
    public void Registration_should_be_successful(){
        boolean bLoginSuccess = false;
        if(Driver.findElements(By.cssSelector("a[title='Log me out']")).size() > 0){
            bLoginSuccess = true;
        }
        Driver.quit();

        if(bLoginSuccess){
            myLog.info("Log: Registration is successful");
        }
        else{
            Assert.fail("Log: Registration is NOT successful");
        }
    }


}