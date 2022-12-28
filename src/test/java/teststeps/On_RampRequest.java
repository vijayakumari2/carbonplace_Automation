package teststeps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class On_RampRequest {
    private LoginPage loginpage;
    private TestContext context;
    private HomePage homepage;
    private LandingPage landingpage;

    private On_RampPage on_rampPage;
    private On_RampRequestPage On_RampRequestPage;

    public On_RampRequest(TestContext context) {
        this.context = context;
        this.homepage = context.getPageObjectManager().getHomePage();
        this.landingpage = context.getPageObjectManager().getLandingPage();
        this.loginpage = context.getPageObjectManager().getLoginPage();
        this.on_rampPage = context.getPageObjectManager().getOn_RampPage();
        this.On_RampRequestPage = context.getPageObjectManager().getOn_RampRequestPage();
    }
    @And("I click on onRampRequest button")
    public void clickingOnRampRequestButton(){
        On_RampRequestPage.clickingOnRampRequestButton();
    }
    @Then("I verify page with- {string}")
    public void verifyOnRampRequest(String text){
        On_RampRequestPage.verifyonRampRequest(text);
    }
    @Then("I verify Project Details in OnRampRequest Page -{string},{string}")
    public void verifyProjectDetails(String projectid, String projectname) {
        On_RampRequestPage.verifyingProjectDetails(projectid, projectname);
    }
    @And("I click on view button")
    public void clickingOnViewButton(){
        On_RampRequestPage.clickingOnViewButton();
    }
}
