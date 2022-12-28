package managers;

import pages.*;

public class PageObjectManager {
	private LoginPage loginPage;
	private LandingPage landingPage;
	private HomePage homepage;
	private ClientPage clientPage;
	private On_RampPage on_rampPage;
	private On_RampRequestPage On_RampRequestPage;;
	private  PortfolioPage portfolioPage;
	private NewCarbonCreditPage newCarbonCreditPage;
	private WebDriverManager app;

	public PageObjectManager() {
		this.app = new WebDriverManager();
	}

	public WebDriverManager getWebDriverManager() {
		return app;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(app);
		return loginPage;
	}

	public LandingPage getLandingPage() {
		if (landingPage == null)
			landingPage = new LandingPage(app);
		return landingPage;
	}

	public HomePage getHomePage() {
		if (homepage == null)
			homepage = new HomePage(app);
		return homepage;
	}
	public ClientPage getClientPage() {
		if (clientPage == null)
			clientPage = new ClientPage(app);
		return clientPage;
	}

    public On_RampPage getOn_RampPage() {
		if (on_rampPage == null)
			on_rampPage = new On_RampPage(app);
		return on_rampPage;
    }
	public NewCarbonCreditPage getNewCarbonCreditPage() {
		if (newCarbonCreditPage == null)
			newCarbonCreditPage = new NewCarbonCreditPage(app);
		return newCarbonCreditPage;
	}
	public On_RampRequestPage getOn_RampRequestPage() {
		if (On_RampRequestPage == null)
			On_RampRequestPage = new On_RampRequestPage(app);
		return On_RampRequestPage;
	}
	public PortfolioPage getPortfolioPage(){
		if (portfolioPage == null)
			portfolioPage = new PortfolioPage(app);
		return portfolioPage;
	}
}
