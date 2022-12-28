package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reports.ExtentManager;

public class WebDriverManager {

	private WebDriver driver;
	private ExtentTest test;
	private Properties prop;
	private Properties envprop;
	private SoftAssert softAssert;

	public WebDriverManager() {
		// init the properties file
		if (prop == null) {
			prop = new Properties();
			envprop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/env.properties");
				prop.load(fs);
				String env = prop.getProperty("env") + ".properties";
				fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/" + env);
				envprop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			softAssert = new SoftAssert();
		}
	}

	/**
	 * This Method is called for opening the browser
	 * 
	 * @param browserlanuch Is the browsername which needs to be sent(fetched from
	 *                      propertyfile)
	 */
	public void openBrowser(String browserlanuch) {
		if (browserlanuch.equals("Chrome")) {
			// options = Options();
			if (envprop.getProperty("OS").equals("linux")) {
				System.out.println(envprop.getProperty(browserlanuch));
				System.setProperty("webdriver.chrome.driver", "chromedriver");
			} else {
				System.out.println(envprop.getProperty(browserlanuch));
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			}
			// ChromeOptions opts = new ChromeOptions();
			// opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			// For running in non gui mode from jenkins
			// *****************
//			opts.setBinary("/opt/google/chrome/chrome");
//
//			opts.addArguments("--no-sandbox");
//			opts.addArguments("-disable-dev-shm-usage");
//			opts.addArguments("--headless");
//
//			opts.addArguments("enable-automation");
//			opts.addArguments("--window-size=1920,1200");
//			opts.setExperimentalOption("useAutomationExtension", false);
//			opts.addArguments("--disable-extensions");
//			opts.addArguments("--disable-gpu");
			// ***************************

			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		} else if (browserlanuch.equals("Firefox")) {
			if (envprop.getProperty("OS").equals("linux")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver");
			} else {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			}
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		} else if (browserlanuch.equals("IE")) {
			System.setProperty("webriver.chrome.driver", "chromedriver");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void init(ExtentTest test) {
		this.test = test;
	}

	/**
	 * This Method is called for opening the browser
	 * 
	 * @param apURlkey Is the url which needs to be sent for the driver to
	 *                 navigate(fetched from propertyfile)
	 */
	public void navigateURL(String apURlkey) {
		log("Naviagting to the URL" + "-" + envprop.getProperty(apURlkey));
		driver.navigate().to(envprop.getProperty(apURlkey));
	}

	/**
	 * This Method is called for getting the webelement
	 * 
	 * @param locatorkey Is the weblemlemt(fetched from propertyfile)
	 * @return will return the weblemt if found or else failure message will be
	 *         logged
	 */
	public WebElement getElement(String locatorkey, boolean asserttype) {
		WebElement e = null;
		try {
			if (locatorkey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));

			else if (locatorkey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorkey)));

			else {
				System.out.println("Locatorykey is not correct" + " " + locatorkey);
				reportFailure("Locatorykey is not correct" + " " + locatorkey, asserttype);
			}
		} catch (Exception ex) {
			reportFailure(ex.getMessage(), asserttype);
			ex.printStackTrace();
		}
		return e;
	}

	/**
	 * This Method is called for getting the webelement
	 * 
	 * @param locatorkey Is the weblemlemt(fetched from propertyfile)
	 * @return will return the weblemt if found or else failure message will be
	 *         logged
	 */
	public WebElement getElement(String locatorkey) {
		WebElement e = null;
		try {
			if (locatorkey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));

			else if (locatorkey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorkey)));

			else {
				System.out.println("Locatorykey is not correct" + " " + locatorkey);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	/**
	 * This Method is called to check whether a webelement is in enable mode to
	 * click or type
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done
	 */
	public void isEnabled(String locatorkey, boolean assertype) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey, assertype)));
		test.log(Status.INFO, "Verifying whether the webelemt-" + locatorkey + "is enabled/clickable");
		String actualValue = Boolean.toString(getElement(locatorkey, assertype).isEnabled());
		String expectedValue = "true";
		if (actualValue.equals(expectedValue)) {
			reportPass("Webelement-" + locatorkey + "is enabled");
		} else {
			reportFailure("Webelement-" + locatorkey + "is not enabled", assertype);
		}
	}

	/**
	 * This Method is called for typing some data in to the webelement
	 * 
	 * @param locatorkey Is the webelement in which data needs to be typed(fetched
	 *                   from propertyfile)
	 * @param data       Is the data what we send to be entered
	 */
	public void type(String locatorkey, String data, boolean assertype) {
		isEnabled(locatorkey, assertype);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey, assertype)))
				.sendKeys((data));
	}
	public void type1(String locatorkey, String data, boolean assertype) {
		isEnabled(locatorkey, assertype);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey, assertype)))
				.sendKeys((data),Keys.TAB,Keys.TAB,Keys.ENTER);
	}
	/**
	 * This Method is called for clicking on a webelement
	 * 
	 * @param locatorkey Is the webelement which needs to be clicked on(fetched from
	 *                   propertyfile)
	 */
	public void click(String locatorkey, boolean assertype)  {
		isEnabled(locatorkey, assertype);
		try {
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.elementToBeClickable(getElement(locatorkey, assertype))).click();
		} catch (Exception ex) {
			reportFailure(ex.getMessage(), assertype);
			ex.printStackTrace();
		}

	}

	/**
	 * This Method is called for clearing data in a webelementt
	 * 
	 * @param locatorkey Is the webelement from which data needs to be
	 *                   cleared(fetched from propertyfile)
	 */
	public void clear(String locatorKey, boolean assertype) {
		log("Clearing text field " + locatorKey);
		getElement(locatorKey, assertype).clear();
	}

	/**
	 * This Method is called for clicking on enter button
	 * 
	 * @param locatorkey Is the webelement on which enter buton needs to be
	 *                   clicked(fetched from propertyfile)
	 */
	public void clickEnterButton(String locatorKey, boolean assertype) {
		log("Clicking enter button");
		getElement(locatorKey, assertype).sendKeys(Keys.ENTER);
	}

	/**
	 * Method that can be called to click on an web element using javascript.
	 * 
	 * @param locatorkey Is the webelement which needs to be clicked(fetched from
	 *                   propertyfile)
	 */
	public void jsclick(String locatorkey, boolean assertype) {
		isEnabled(locatorkey, assertype);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", new WebDriverWait(driver, 30)
					.until(ExpectedConditions.elementToBeClickable(getElement(locatorkey, assertype))));
		}

		catch (Exception ex) {
			reportFailure(ex.getMessage(), assertype);
			ex.printStackTrace();
		}
	}

	/**
	 * This Method is called to check whether webelement is present in the opened
	 * page or not
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 * @return Boolen ,will return true if webelemt is found or else will return
	 *         false
	 */
	public boolean isElementPresent(String locatorkey, boolean assertype) {
		try {
			List<WebElement> webelementlist = null;

			if (locatorkey.endsWith("_xpath"))
				webelementlist = driver.findElements(By.xpath(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_id"))
				webelementlist = driver.findElements(By.id(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_name"))
				webelementlist = driver.findElements(By.name(prop.getProperty(locatorkey)));
			else {
				takeScreenShot();
				reportFailure("Locator not found" + locatorkey, assertype);
			}
			if (webelementlist.size() == 0) {
				reportFailure("Webelement is not Present", assertype);
				return false;
			} else {
				reportPass("Webelement is Present");
				return true;
			}
		} catch (Exception ex) {
			reportFailure(ex.getMessage(), assertype);
			ex.printStackTrace();
			Assert.fail("Fail the test" + ex.getMessage());
			return false;
		}
	}

	/**
	 * This Method is called to check whether webelement is not present in the
	 * opened page or not
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 * @return Boolen ,will return true if webelemt is not found or else will return
	 *         false
	 */
	public boolean isElementnotPresent(String locatorkey, boolean assertype) {
		List<WebElement> webelementlist = null;

		if (locatorkey.endsWith("_xpath"))
			webelementlist = driver.findElements(By.xpath(prop.getProperty(locatorkey)));
		else if (locatorkey.endsWith("_id"))
			webelementlist = driver.findElements(By.id(prop.getProperty(locatorkey)));
		else if (locatorkey.endsWith("_name"))
			webelementlist = driver.findElements(By.name(prop.getProperty(locatorkey)));
		else {
			takeScreenShot();
			reportFailure("Locator not found" + locatorkey, assertype);
			Assert.fail("Locator not found" + locatorkey);
		}
		if (webelementlist.size() == 0) {
			reportPass("Webelement is not Present");
			return false;
		} else {
			reportFailure("Webelement is Present", assertype);
			return true;
		}
	}

	/**
	 * This Method is called for the test execution to wait explictily,till all the
	 * weblements are loaded(js script)
	 */
	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;
		// ajax status
		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
			System.out.println(state);
			if (state.equals("complete"))
				break;
			else
				wait(2);
			i++;
		}
		// check for jquery status
		i = 0;
		while (i != 10) {
			Long d = (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if (d.longValue() == 0)
				break;
			else
				wait(2);
			i++;
		}
	}

	/**
	 * This Method is called for the test execution to wait explictily,till the
	 * loader icon is not visible
	 */
	public boolean waitForPageLoaderToDisapper() {
		new WebDriverWait(driver, 15, 0)
				.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//div[@class='loader']"))));
		return true;
	}

	/**
	 * This Method is called for the test execution to wait explictily,till the
	 * loader icon is not visible at login page
	 */
	public boolean waitForLoginPageLoaderToDisapper() {
		new WebDriverWait(driver, 10, 0)
				.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='loader']"))));
		wait(8000);
		new WebDriverWait(driver, 15, 0)
				.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//div[@class='loader']"))));
		return true;
	}

	/**
	 * This Method is called for the test execution to wait explictily,till the
	 * webelement is loaded
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 */
	public void explictwait(String locatorkey) {
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey,true)));
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.elementToBeClickable(getElement(locatorkey,true)));
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
		// wait(5000);
		// new WebDriverWait(driver,
		// 50).until(ExpectedConditions.invisibilityOf(getElement(locatorkey)));
	}

	/**
	 * This Method is called for the test execution to wait implicitily,till the
	 * speceified time
	 * 
	 * @param milliseconds Is the time for the application to wait
	 */
	public void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This Method is called for printing messages in the report
	 * 
	 * @param msg Pass the message which needs to printed
	 */
	public void log(String msg) {
		test.log(Status.INFO, msg);
	}

	/**
	 * This Method is called to log in the report when a test cases is failed and
	 * also we can pass type of failure using the stoponfailure param
	 * 
	 * @param failuremsg    Pass the message which needs to printed
	 * @param stoponfailure Pass boolean value to specify whether it is critical
	 *                      failure or not
	 */
	public void reportFailure(String failuremsg, boolean stoponfailure) {

		test.log(Status.FAIL, MarkupHelper.createLabel(failuremsg, ExtentColor.RED));// report failure in extent report
		takeScreenShot();// Put screen-shot in report
		softAssert.fail(failuremsg);// report failure in testng
		if (stoponfailure == true) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("CriticalFailure", "Y");
			AssertAll();
		}
	}

	/**
	 * This Method is called to stop the test execution
	 */
	public void AssertAll() {
		softAssert.assertAll();
	}

	/**
	 * This Method is called to log in the report when a test case is passed
	 * 
	 * @param msg Pass the message which needs to printed
	 */
	public void reportPass(String msg) {
		test.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		takeScreenShot();
	}

	/**
	 * This Method is called to take a screen-shot
	 */
	public void takeScreenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// Take Screen-shot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFolderPath + "/" + screenshotFile));
			// adding the screen-shot in extent reports

			// ExtentTest.log(Status.INFO,"Screenshot-> "+
			// ExtentTest.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+ "/" +
			// screenshotFile));
			test.log(Status.INFO, "Screenshot-> "
					+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + "/" + screenshotFile));
			// MediaEntityBuilder
			// test.log(Status.INFO,"Screenshot-> "+
			// MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotFolderPath+
			// "/" + screenshotFile).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This Method is called to accept the Alert
	 */
	public void acceptAlert() {
		log("Switching to alert");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log("Alert accepted successfully");
		} catch (Exception e) {
			reportFailure("Alert not found when mandatory", true);
		}
	}

	/**
	 * This Method is called to refresh the webpage
	 */
	public void pageRefesh() {
		driver.navigate().refresh();
	}

	/**
	 * This Method is called to close all the windows and end the webdriver session
	 */
	public void quit() {
		driver.quit();
	}

	/**
	 * This Method is called to verify the current page title
	 * 
	 * @param ActualTitle Is the expcetd title(fetched from propertyfile)
	 * @param asserttype  Is a boolean which tells what type of assertion should be
	 *                    done in case of pass and failure whether hardassert or
	 *                    sortassert should be done.
	 * @return Boolen ,will return true if title is present or else will return
	 *         false
	 */
	public boolean validateTitle(String ExpectedTitle, boolean assertype) {
		log("Validating Page title");
		String expectedtitle = prop.getProperty(ExpectedTitle);
		String actualitle = driver.getTitle().trim();
		if (expectedtitle.equals(actualitle)) {
			reportPass("Title is as expected -" + prop.getProperty(ExpectedTitle));
			return true;
		} else {
			reportFailure("Title is not as expected -" + prop.getProperty(ExpectedTitle), assertype);
			return false;
		}
	}

	/**
	 * This Method is called to verify the selected value is present in drop-down
	 * values
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param option     is the excpeted value
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 */
	public void validateSelectedValueInDropDown(String locatorKey, String option, boolean assertype) {
		Select s = new Select(getElement(locatorKey, assertype));
		String text = s.getFirstSelectedOption().getText();
		if (!text.equals(option)) {
			reportFailure("Option" + option + " not present in Drop Down " + locatorKey, assertype);
		}
	}

	/**
	 * This Method is called to verify the selected value is not present in
	 * drop-down values
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param option     is the excpeted value
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 */
	public void validateSelectedValueNotInDropDown(String locatorKey, String option, boolean assertype) {
		Select s = new Select(getElement(locatorKey, assertype));
		String text = s.getFirstSelectedOption().getText();
		if (text.equals(option)) {
			reportFailure("Option" + option + " present in Drop Down " + locatorKey, assertype);
		}
	}

	/**
	 * This Method is called to check whether text is present in the opened webpage
	 * or not
	 * 
	 * @param locatorkey Is the webelement(fetched from propertyfile)
	 * @param text       Is the text which needs to be verified
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 * @return Boolen ,will return true if tex is present or else will return false
	 */
	public boolean verifyText(String locatorkey, String text, boolean asserttype) {
		String ActualText = getElement(locatorkey, asserttype).getText().trim();
		String ExpectedText = prop.getProperty(text);
		if (ActualText.equals(ExpectedText)) {
			reportPass("Text is present in the webpage based on the locatorkey");
			return true;
		} else {
			reportFailure("Text is not present in the webpage based on the locatorkey", asserttype);
			return false;
		}
	}

	/**
	 * This Method is called to check whether text is present in the opened webpage
	 * or not
	 * 
	 * @param text       Is the text which needs to be verified
	 * @param passm      Is the success message which we log in the report if text is
	 *                   present in the page
	 * @param failm      Is the failure message which we log in the report if text
	 *                   is not present in the page
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 */
	public boolean verifyTextinPage(String text, boolean asserttype) {
		if (driver.getPageSource().contains(text)) {
			reportPass(text + " " + "is present in the webpage");
			Reporter.log("verified successfully",true);
			return true;
		} else {
			reportFailure(text + " " + "is not present in the webpage", asserttype);
			Reporter.log("verification failed",true);
			return false;
		}
	}

	/**
	 * This Method is called to check whether text is not present in the opened
	 * webpage or not
	 * 
	 * @param text       Is the text which needs to be verified
	 * @param passm      Is the success message which we log in the report if text is
	 *                   present in the page
	 * @param failm      Is the failure message which we log in the report if text
	 *                   is not present in the page
	 * @param asserttype Is a boolean which tells what type of assertion should be
	 *                   done in case of pass and failure whether hardassert or
	 *                   sortassert should be done.
	 */
	public boolean verifyTextNotinPage(String text, boolean asserttype) {
		if (driver.getPageSource().contains(text)) {
			reportFailure(text + " " + "is present in the webpage", asserttype);
			return false;
		} else {
			reportPass(text + " " + "is not present in the webpage");
			return true;
		}
	}

	public void selectValueDropdownbyText(String locatorkey, String text) {
		Select select = new Select(getElement(locatorkey));
		select.selectByVisibleText(text);
	}

//	public int getLeadRowNumberWithCellData(String leadName) {
//		List<WebElement> names = driver.findElements(getLocator("leadnames_css"));
//		for(int i=0;i<names.size();i++) {
//			if(leadName.equalsIgnoreCase(names.get(i).getText()))
//				return (i+1);
//		}
//		
//		return -1;// not found
//	}

	public void selectLeadCheckBox(int rowNum) {
		driver.findElement(
				By.cssSelector("lyte-exptable-tr:nth-child(" + rowNum + ") > lyte-exptable-td:nth-child(2) label"))
				.click();

	}
	public void mouseMovement(){
		Actions actions=new Actions(driver);
		WebElement ele =driver.findElement(By.xpath("(//input[@type='checkbox'])[last()]"));
		actions.moveToElement(ele).perform();
	}
	public void scrollMovement(){

		JavascriptExecutor jse=(JavascriptExecutor)  driver;
		jse.executeScript("window.scrollBy(0,500);");
	}
	public void explicitWait(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele =driver.findElement(By.xpath("//span[text()='Create New Project']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void explicitWait1(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele =driver.findElement(By.xpath("(//span[text()='On-Ramp Credits'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void doubleClick(){
		Actions act =new Actions(driver);
		act.doubleClick(getElement("searchbox_xpath",true)).perform();
	}
	public void waits(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele =driver.findElement(By.xpath("//span[@class='ui-table-total-results']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
