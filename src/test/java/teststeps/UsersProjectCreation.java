package teststeps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ClientPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class UsersProjectCreation {
    private LoginPage loginpage;
    private ClientPage clientPage;
    private TestContext context;
    private HomePage homepage;
    private LandingPage landingpage;

    public UsersProjectCreation(TestContext context) {
        this.context = context;
        this.homepage = context.getPageObjectManager().getHomePage();
        this.landingpage = context.getPageObjectManager().getLandingPage();
        this.loginpage = context.getPageObjectManager().getLoginPage();
        this.clientPage=context.getPageObjectManager().getClientPage();
    }
    @Given("I enter {string} and {string} in Cp Login Page")
    public void loginDetails(String emailAddress, String password) {
        loginpage.enteringLoginDetails(emailAddress, password);
    }
    @And("I click on Continue button")
    public void clickContinue() {
        loginpage.clickingonContinue();
    }
    @Then("I verify Home Page - {string}")
    public void verifyHomePage(String text) {
        homepage.verifyingHomePage(text);
    }

}
