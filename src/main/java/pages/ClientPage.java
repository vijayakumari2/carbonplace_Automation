package pages;


import managers.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class ClientPage {
    private WebDriverManager app;
    public ClientPage(WebDriverManager app) {
        this.app=app;
    }
    public void verifyingCreateBankTitle() {
        app.log("Verifying the Page Title");
        app.validateTitle("Bankactualtitle", false);
    }
    public void clickOnMenu(){
        app.wait(3000);
        app.log("Clicking on Clientmanagement button");
        app.click("menu_xpath", true);

    }
    public void clickOnClientManagement(){

        app.log("Clicking on Clientmanagement button");
        app.click("Clientmanagement_xpath", true);
    }
    public void clickOnTypeButton(){
        app.log("Clicking on CreateNewClient button");
        app.click("Type_xpath", true);
    }
    public void clickOnCreateNewClient(){

        app.log("Clicking on CreateNewClient button");
        app.click("Createnewclient_xpath", true);
    }
    public void clickOnCreateNewBank(){
        app.log("Clicking on CreateNewBank option");
        app.click("Createnewbank_xpath", true);
    }
    public void clickOnCreateNewBroker(){
        app.log("Clicking on CreateNewBank option");
        app.click("Createnewbroker_xpath", true);
    }
    public void clickOnCreateNewObserver(){
        app.log("Clicking on CreateNewBank option");
        app.click("Createnewobserver_xpath", true);
    }
    public void enteringName(String bankName){
        app.log("Entering valid Bankname "+bankName);
        app.type("name_xpath", bankName, true);
    }
    public void enteringFirstName(String firstName){
        app.log("Entering valid  admin firstname "+firstName);
        app.type("adminfirstName_xpath", firstName, true);
    }
    public void enteringLastName(String lastName){
        app.log("Entering valid  admin lastName "+lastName);
        app.type("adminLastName_xpath", lastName, true);
    }

    public void enteringEmailAddress(String email){
        app.log("Entering valid  admin lastName "+email);
        app.type("adminEmailAddress_xpath", email, true);
    }
    public void clickingOnSubmit(){
        app.log("Clicking on submit button");
        app.click("submitbutton_xpath", true);
    }

    public void verifyingBankName(String bankname){

            app.log("Verifying whether" +bankname+ "is present in CP Login Page");
            app.verifyTextinPage(bankname, false);

    }
    public void selectingType(String typeName){
        app.log("selecting a type button");
        app.mouseMovement();
        app.click("observerType_xpath",true);
        app.click("mouseMovement_xpath",true);
           }

    public  void validatingType(String typeName){
        app.log("verification of a text");
        app.verifyText("validation_xpath",typeName,true);
    }


}
