package pages;

import managers.WebDriverManager;

public class LoginPage {
	private WebDriverManager app;

	public LoginPage(WebDriverManager app) {
		this.app=app;
	}

	public void verifyingLoginPageTitle() {
		app.log("Verifying the Page Title");
		app.validateTitle("loginPageactualtitle", false);	
	}
	
	public void verifyingLoginPage(String text) {
		app.log("Verifying whether" +text+ "is present in CP Login Page");
		app.verifyTextinPage(text, false);
	}

	public void enteringLoginDetails(String emailaddress, String password) {
		app.log("Entering valid Email Address and Password - "+emailaddress+" and "+password);
		app.type("emailaddress_xpath", emailaddress, true);
		app.type("password_xpath", password, true);
	}

	public void clickingonContinue() {
		app.log("Clicking on Continue button");
		app.click("Continuebutton_xpath", true);
	}
	
	public void clickingonShowPassword(String buttonname) {
		app.log("Clicking on "+buttonname+" Password button");
		app.click("showpasswordbutton_xpath", false);
	}

	public void verifyShowPassword(String password) {
		app.log("Verifying whether user is able to see the password when clicked on show password");
		app.click("showpasswordbutton_xpath", false);
		if (app.verifyTextinPage(password, false) == true) {
			app.reportPass("User is able to see the password when clicked on show password");
		} else {
			app.reportFailure("User is not able to see the password when clicked on show password", false);
		}
	}

	public void verifyHidePassword(String password) {
		app.log("Verifying whether user is able to hide the password when clicked on hide password");
		app.click("showpasswordbutton_xpath", false);
		if (app.verifyTextNotinPage(password, false) == true) {
			app.reportPass("User is able to mask the password when clicked on hide password");
		} else {
			app.reportFailure("User is not able to mask the password when clicked on hide password", false);
		}
	}
	
	public void invalidLoginErrorMessVerification(String errormessage ) {

		app.verifyTextinPage(errormessage, false);
	}
	
	public void submitWithoutLoginDetails(){

		app.click("Continuebutton_xpath", false);
	}
	
	public void noLoginDetailsMessVerification(String errormessage ) {
		app.verifyTextinPage(errormessage, false);
	}


}
