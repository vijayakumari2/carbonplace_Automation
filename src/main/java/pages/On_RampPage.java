package pages;

import managers.WebDriverManager;

public class On_RampPage {
    private WebDriverManager app;
    public On_RampPage(WebDriverManager app) {
        this.app=app;
    }

    public void clickingOnOn_Ramp(){
        app.log("Clicking on On_Ramp option");
        app.click("onRampCredits_xpath", true);
    }
    public void verifyingOnRampPage(String text) {
        app.wait(20000);
        app.log("Verifying whether" +text+ "is present in CP Home Page");
        app.verifyTextinPage(text, false);
    }
    public void clickingOnRegistry(){
        app.log("Clicking on Registry");
        app.click("registry_xpath", true);
    }
    public void enteringId(String projectId){
        app.log("Entering valid projectId "+projectId);
        app.type("projectId_xpath", projectId, true);
        app.wait(2000);
        app.scrollMovement();
        app.explicitWait();

    }
    public void enteringExistedId(String projectId){
        app.log("Entering valid projectId "+projectId);
        app.type("projectId_xpath", projectId, true);
        app.wait(2000);
        app.scrollMovement();
        app.explicitWait1();

    }
    public void selectingProject(){
        app.log("selecting existing project");
        app.click("existedproject_xpath",true);
        app.wait(2000);

    }
    public void clickCreateNewProject(){
        app.log("Clicking on createNewProject button");
        app.click("createNewProjectButton_xpath", true);
    }
    public void verifyCarbonCreditPage(String text) {
        app.wait(20000);
        app.log("Verifying whether" +text+ "is present in CP Home Page");
        app.verifyTextinPage(text, false);
    }
//    public void enteringDetails(){
//      n.projectName();
//    }
    public void clickingOnRampCredits(){

        app.log("clicking on-ramp credits");

        app.click("onRampCreditsButton_xpath",true);
    }
    public void enteringVintage(String vinatge){
        app.log("entering the value of vintage");
        app.type("vintage_xpath",vinatge,true);
    }
    public void enteringQuantity(String quantity){
        app.log("entering the value of vintage");
        app.type("quantity_xpath",quantity,true);
    }
}
