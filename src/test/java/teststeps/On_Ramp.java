package teststeps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class On_Ramp {
    private LoginPage loginpage;
    private TestContext context;
    private HomePage homepage;
    private LandingPage landingpage;

    private On_RampPage on_rampPage;

    public On_Ramp(TestContext context) {
        this.context = context;
        this.homepage = context.getPageObjectManager().getHomePage();
        this.landingpage = context.getPageObjectManager().getLandingPage();
        this.loginpage = context.getPageObjectManager().getLoginPage();
        this.on_rampPage = context.getPageObjectManager().getOn_RampPage();
    }
    @When("I click on OnRampCredits option")
    public void clickOnRampCredits(){

        on_rampPage.clickingOnOn_Ramp();
    }
    @Then("I verify on-ramp projects page-{string}")
    public void verifyOnRampPage(String text) {
        on_rampPage.verifyingOnRampPage(text);
    }
    @When ("I click on selected Registry")
    public void clickOnRegistry(){
        on_rampPage.clickingOnRegistry();
    }
    @And("I enter {string}")
    public void enteringId(String projectId){
        on_rampPage.enteringId(projectId);
    }
    @And("I click on CreateNewProject")
    public void clickingCreateNewProject(){
        on_rampPage.clickCreateNewProject();
    }
    @Then("I verify carbonCredit page-{string}")
    public void verifyCarbonCreditPage(String text){
        on_rampPage.verifyCarbonCreditPage(text);
  }
    @And("I enter  existed {string}")
    public void enteringExistedProject(String projectId){
        on_rampPage.enteringExistedId(projectId);
    }
    @And("I select the required project")
    public void selectingProject(){
        on_rampPage.selectingProject();
    }
    @And("I click OnRampCredits button")
    public void clickingOnRampCredits(){
        on_rampPage.clickingOnRampCredits();
    }
    @And("I enter the {string}")
    public void enteringVintage(String vintage){
        on_rampPage.enteringVintage(vintage);
    }
    @And("I enter the value of  {string}")
    public void enteringQuantity(String quantity){
        on_rampPage.enteringQuantity(quantity);
    }

}