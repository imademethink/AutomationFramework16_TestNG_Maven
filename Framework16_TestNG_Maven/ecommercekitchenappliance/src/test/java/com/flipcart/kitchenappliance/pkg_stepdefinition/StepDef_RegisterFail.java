package com.flipcart.kitchenappliance.pkg_stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.flipcart.kitchenappliance.pkg_hooks.GlobalObjects;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepDef_RegisterFail extends GlobalObjects {
    private static final Logger myLog = Logger.getLogger(StepDef_RegisterFail.class);

    @Test
    @Given("^User navigates to registration screen only$")
    public void User_navigates_to_registration_screen_only(){
        String sUrlRegister = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        myLog.info("Log: Navigating to " + sUrlRegister);
        GlobalDriver.get(sUrlRegister);
        GlobalDriver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Test
    @When("^User attempts to register with invalid data$")
    public void User_attempts_to_register_with_invalid_data(){

        myLog.info("Log: Registration begins");
        GlobalDriver.findElement(By.id("email_create")).sendKeys(
                "randomname" + new Random().nextInt(99999) + "@mailinator.com");
        GlobalDriver.findElement(By.cssSelector("i[class*='icon-user']")).click();
        GlobalDriver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

        GlobalDriver.findElement(By.id("customer_firstname")).sendKeys("NameFirst");
        GlobalDriver.findElement(By.id("customer_lastname")).sendKeys("NameLast");
        GlobalDriver.findElement(By.id("passwd")).sendKeys("Abcd@1234");

        GlobalDriver.findElement(By.id("submitAccount_fake")).click();
    }
}
