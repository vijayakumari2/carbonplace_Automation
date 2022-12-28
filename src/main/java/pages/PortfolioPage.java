package pages;

import managers.WebDriverManager;

public class PortfolioPage {
    private WebDriverManager app;

    public PortfolioPage(WebDriverManager app) {
        this.app=app;
    }
    public void verifyingPortfolioPageTitle() {
        app.log("Verifying the Page Title");
        app.validateTitle("PortfolioPageactualtitle", false);
    }
    public void verifyingPortfolioPagePage(String text) {
        app.log("Verifying whether" +text+ "is present in CP PortfolioPage");
        app.verifyTextinPage(text, false);
    }
    public void searchWithProjectId(String data){
        app.log("Verifying whether" +data+ "is present in CP PortfolioPage");
        app.type("projectsearchbar_xpath", data, false);
    }

}
