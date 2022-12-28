package pages;

import managers.WebDriverManager;

public class On_RampRequestPage {
    private WebDriverManager app;
    public On_RampRequestPage(WebDriverManager app) {
        this.app=app;
    }
    public void clickingOnRampRequestButton(){
        app.log("clicking onRampRequest button");
        app.click("onRampRequest_xpath",true);
    }

    public void verifyonRampRequest(String text){
        app.wait(20000);
        app.log("Verifying whether" +text+ "is present in CP Home Page");
        app.verifyTextinPage(text, false);

    }
    public void verifyingProjectDetails(String projectid, String projectname) {
        app.log("Verifying " + projectid + " and " + projectname + " are displaying");
        app.isElementPresent("projectidtext_xpath", false);
        app.verifyText("projectname_xpath", projectname, false);
    }
    public void clickingOnViewButton(){
        app.log("clicking on view button");
        app.click("viewButton_xpath",true);
    }
}
