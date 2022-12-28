package pages;

import managers.WebDriverManager;

public class HomePage{

private WebDriverManager app;

public HomePage(WebDriverManager app) {
	this.app=app;
}

public void verifyingLoadHomePage() {
	app.log("Verifying the Page Title");
	app.validateTitle("actualtitle", false);	
}

public void verifyingHomePage(String text) {
	app.wait(20000);
	app.log("Verifying whether" +text+ "is present in CP Home Page");
	app.verifyTextinPage(text, false); 
}
}
