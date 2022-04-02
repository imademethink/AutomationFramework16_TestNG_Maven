package pkg_stepdefinition;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class StepDef_zDummy {
    private static final Logger myLog = Logger.getLogger(StepDef_zDummy.class);

    @Test
    @When("^Statement (\\d+)$")
    public void Statement(int n) {
        myLog.info("Log: "+n);
    }


}