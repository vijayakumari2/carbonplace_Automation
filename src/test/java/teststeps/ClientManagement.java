package teststeps;

import context.TestContext;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.ClientPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class ClientManagement {
    private LoginPage loginpage;
    private ClientPage clientPage;
    private TestContext context;
    private HomePage homepage;
    private LandingPage landingpage;

    public ClientManagement(TestContext context) {
        this.context = context;
        this.homepage = context.getPageObjectManager().getHomePage();
        this.landingpage = context.getPageObjectManager().getLandingPage();
        this.loginpage = context.getPageObjectManager().getLoginPage();
        this.clientPage=context.getPageObjectManager().getClientPage();
    }


    @When("I click on menu button")
    public void clickOnMenu(){
        clientPage.clickOnMenu();
    }
    @When("I click on Client management page")
    public  void clickOnClientManagement(){
        clientPage.clickOnClientManagement();
    }

    @Then("I verify the client management page-'Create New Client'")
    public void verifyClientManagementPage(String text) {
        homepage.verifyingHomePage(text);
    }

    @And ("I click on Create new client button")
    public  void clickOnCreateNewClient(){
        clientPage.clickOnCreateNewClient();
    }
    @And("I click on Create new Bank option")
    public void clickOnCreateNewBank(){
        clientPage.clickOnCreateNewBank();
    }

    @And("I click on Create new Broker option")
    public void clickOnCreateNewBroker(){
        clientPage.clickOnCreateNewBroker();
    }
    @And("I click on Create new Observer option")
    public void clickOnCreateNewObserver(){
        clientPage.clickOnCreateNewObserver();
    }
    @When("I enter {string} value")
    public void enterName(String bankName){
        clientPage.enteringName(bankName);
    }
    @And("I enter a {string} value")
    public void enterFirstName(String firstName){
        clientPage.enteringFirstName(firstName);
    }
    @When("I enter the {string} value")
    public void enterLastName(String lastName){
        clientPage.enteringLastName(lastName);
    }
    @And("I entering {string} value")
    public void enterEmailAddress(String email){
        clientPage.enteringEmailAddress(email);

    }
    @When("I click on Create  bank button")
    public void clickingOnCreateBank(){
        clientPage.clickingOnSubmit();
    }
    @When("I click on Create  broker button")
    public void clickingOnCreateBroker(){
        clientPage.clickingOnSubmit();
    }
    @When("I click on Create  observer button")
    public void clickingOnCreateObserver(){
        clientPage.clickingOnSubmit();
    }

    @Then("I verify bankname  with {string}and {string}")
    public void verifyWithFirstnameAndLastname(String bankname){
        clientPage.verifyingBankName(bankname);
    }


    @And("I click on type button")
    public void clickOnTypeButton(){
        clientPage.clickOnTypeButton();
    }
    @And("I select on {string}")
    public void selectingType(String typename){
        clientPage.selectingType(typename);
    }
    @Then("I verify {string} is available")
    public void validatingType(String typename){
        clientPage.validatingType(typename);
    }

}
