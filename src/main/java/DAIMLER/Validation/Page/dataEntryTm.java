package DAIMLER.Validation.Page;

	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.openqa.selenium.WebDriver;

	import com.aventstack.extentreports.ExtentTest;

	import DAIMLER.Validation.Base.Object;


	public class dataEntryTm {
		private WebDriver driver;
		ExtentTest logger;
		Object OBJECT;

		public dataEntryTm(WebDriver d, ExtentTest logger) {
			this.driver = d;
			this.logger = logger;
			OBJECT = new Object(driver, logger);

	}
		public void dataEntryTm() throws FileNotFoundException, IOException {
			
			OBJECT.utility().URL("http://13.68.151.15/MatexTesting/Matrix/DETMDashboard.aspx");
			
		}

	
	
	
	
	
	
	
	}
