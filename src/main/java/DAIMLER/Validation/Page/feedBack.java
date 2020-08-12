package DAIMLER.Validation.Page;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import DAIMLER.Validation.Base.Object;

public class feedBack {
	
	private WebDriver driver;
	ExtentTest logger;
	Object OBJECT;

	public feedBack(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);
	}	
	
	public void QGate(String gateName) {
		OBJECT.utility().clickElement("xpath", "(//button[@data-id='drpQGate']/span)[1]");
		OBJECT.utility().scrollToElement("xpath", "//span[@class='text trn' and text()='"+gateName+"']");
		OBJECT.utility().clickElement("xpath", "//span[@class='text trn' and text()='"+gateName+"']");
	}
	
	public void vehicleType(String vehicleType) {
		OBJECT.utility().clickElement("xpath", "//button[@id='AdrpModel']/span");
		OBJECT.utility().scrollToElement("xpath", "//div[@class='ms-drop bottom']/ul/li/label/span[text()='"+vehicleType+"']");
		OBJECT.utility().clickElement("xpath", "//div[@class='ms-drop bottom']/ul/li/label/span[text()='"+vehicleType+"']");
	}
	
	public void Varient(String Varient) throws InterruptedException {
		OBJECT.utility().clickElement("xpath", "//button[@id='AdrpVariant']");
		OBJECT.utility().scrollToElement("xpath", "//div[@class='ms-drop bottom']/ul/li/label/span[text()='"+Varient+"']");
		OBJECT.utility().clickElement("xpath", "//div[@class='ms-drop bottom']/ul/li/label/span[text()='"+Varient+"']");
	}
	
	public void VINno(String VINno) {
		OBJECT.utility().clearField("id", "txtVIN");
		OBJECT.utility().sendKey("id", "txtVIN", VINno);
	}
	
	public void Customer(String customerName) {
		OBJECT.utility().clearField("id", "txtCustomer");
		OBJECT.utility().sendKey("id", "txtCustomer", customerName);
	}
	
	public void Search() {
		OBJECT.utility().clickElement("id", "QFLFeedbackSearch");
		OBJECT.utility().clickElement("id", "btnSearch");
	}
	
	public void totalCheckItemTab() {
		OBJECT.utility().clickElement("xpath", "//div[@id='dvCheckListCount']/table/thead/tr/th/a/span[text()='Total Check Items']");		
	}
	
	public void OkTab() {
		OBJECT.utility().clickElement("xpath", "//div[@id='dvCheckListCount']/table/thead/tr/th/a/span[text()='Ok']");		
	}
	
	public void notOkTab() {
		OBJECT.utility().clickElement("xpath", "//div[@id='dvCheckListCount']/table/thead/tr/th/a/span[text()='Not Ok']");		
	}
	
	public void SkippedTab() {
		OBJECT.utility().clickElement("xpath", "//div[@id='dvCheckListCount']/table/thead/tr/th/a/span[text()='Skipped']");		
	}
	
	public void PendingTab() {
		OBJECT.utility().clickElement("xpath", "//div[@id='dvCheckListCount']/table/thead/tr/th/a/span[text()='Pending']");		
	}
	
	public void selectAction() {
		
		int rowCount = OBJECT.utility().elementCount("xpath", "//table[@id='tblQFLFeedback']/tbody/tr[contains(@class,'trtblSchedule')]");
		System.out.println("rowCount :"+rowCount);
		
		for(int rowIndex=1; rowIndex<= rowCount;rowIndex++) {
		System.out.println("rowIndex :"+rowIndex);
		OBJECT.utility().clickElement("xpath", "//table[@id='tblQFLFeedback']/tbody/tr[contains(@class,'trtblSchedule')][1]/td[@class='feebback-pending-td']/span/a[contains(@onclick,'undefined,2')]");
		}		
	}

}
