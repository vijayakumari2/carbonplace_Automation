package teststeps;

import context.TestContext;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import pages.*;

public class CIX_flow1 {
    private LoginPage loginpage;
    private TestContext context;
    private HomePage homepage;
    private LandingPage landingpage;

    private On_RampPage on_rampPage;
    private On_RampRequestPage On_RampRequestPage;

    private PortfolioPage portfolioPage;

    public CIX_flow1( TestContext context) {
        this.context = context;
        this.homepage = context.getPageObjectManager().getHomePage();
        this.landingpage = context.getPageObjectManager().getLandingPage();
        this.loginpage = context.getPageObjectManager().getLoginPage();
        this.on_rampPage = context.getPageObjectManager().getOn_RampPage();
        this.On_RampRequestPage = context.getPageObjectManager().getOn_RampRequestPage();
        this.portfolioPage=context.getPageObjectManager().getPortfolioPage();
    }
    @When("I search with Project Id-{string}")
    public void searchWithProjectId(String projectId){
        portfolioPage.searchWithProjectId(projectId);

    }
}
