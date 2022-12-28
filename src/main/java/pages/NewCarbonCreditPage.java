package pages;

import managers.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCarbonCreditPage {
    private WebDriverManager app;
    public NewCarbonCreditPage(WebDriverManager app) {
        this.app=app;
    }
    @FindBy(xpath = "//input[@id='carbon_credits_project_details_project_name']")
    private WebElement projectName;
    @FindBy(id = "carbon_credits_project_details_project_description")
    private WebElement projectDescrip;
    @FindBy(xpath = "//input[@id='carbon_credits_project_details_project_link']")
    private WebElement projectlink;

//    NewCarbonCreditPage(){
//        app.pageFactor();
//    }
    public WebElement getProjectName(){
        return projectName;
    }
    public void projectName(){
        getProjectName().sendKeys("bcd");
    }
}
