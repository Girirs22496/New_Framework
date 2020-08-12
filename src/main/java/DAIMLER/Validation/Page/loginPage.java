package DAIMLER.Validation.Page;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import DAIMLER.Validation.Base.Object;

public class loginPage {

	private WebDriver driver;
	ExtentTest logger;
	Object OBJECT;

	public loginPage(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);
	}

	public void loginPage() throws FileNotFoundException, IOException {

		OBJECT.utility().URL("http://13.68.151.15/MatexTesting/Default.aspx");
		OBJECT.utility().sendKey("id", "txtUsername", "demotl");
		OBJECT.utility().sendKey("id", "txtPassword", "Jul@2020");
		OBJECT.utility().clickElement("id", "btnLogin");
		String title = OBJECT.utility().getTitle();
		System.out.println("Title of page is " + title);
		
	
	
	
	
	}
}
