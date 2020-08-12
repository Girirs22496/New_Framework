package DAIMLER.Validation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import DAIMLER.Validation.Base.Object;

public class homePage {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;
	Object OBJECT;

	public homePage(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);
	}

	public void homePage() {
		OBJECT.utility().clickElement("id", "AutomatedQFL");
	}

	public void plantSelect(String plantName) {
		OBJECT.utility().clickElement("id", "AdrpPlant");
		OBJECT.utility().clickElement("xpath", "//span[text()='" + plantName + "']");
	}

	public void extras() {
		OBJECT.utility().clickElement("xpath", "//span[text()='Extras']");
	}
	
	public void QFLfeedback() {
		OBJECT.utility().clickElement("xpath", "//span[text()='QFL Feedback']");
	}
	
	public void progressMonitor() {
		OBJECT.utility().clickElement("xpath", "//span[text()='Progress Monitor']");
	}
	
	public void report() {
		OBJECT.utility().clickElement("xpath", "//span[text()='Reports']");
	}
}
