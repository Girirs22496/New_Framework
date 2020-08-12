package DAIMLER.Validation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import DAIMLER.Validation.Base.Object;

public class extraPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;
	Object OBJECT;

	public extraPage(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);
	}

	public void QGateMaster() {
		OBJECT.utility().clickElement("id", "liQGateMaster");
	}

	public void vehicleTypeMaster() {
		OBJECT.utility().clickElement("xpath", "//span[text()='Vehicle Type Master']");
	}

	public void varientMaster() {
		OBJECT.utility().clearField("xpath", "//span[text()='Variant Master']");
	}

	public void wingLine() {
		gateCreation("testAutomation", 1);
	}

	public void flatBodyLine() {
		gateCreation("testAutomation", 2);
	}

	public void vanLine() {
		gateCreation("testAutomation", 3);
	}

	public void CTTLine() {
		gateCreation("testAutomation", 4);
	}

	public void gateCreation(String gateName, int indexOfAdd) {
		OBJECT.utility().clickElement("xpath",
				"(//i[@class='fas fa-plus-circle addList tooltip-QGList'])[" + indexOfAdd + "]");
		OBJECT.utility().sendKey("id", "txtQGateName", gateName);
		OBJECT.utility().clickElement("id", "btnSubmit");
		OBJECT.utility().clickElement("xpath", "(//span[text()='OK'])[2]");
	}

	public void editGate(String oldGateName, String newGateName) {
		OBJECT.utility().clickElement("xpath", "//li[@class='slide tooltip-QGList NoRework' and text()='" + oldGateName
				+ "']//i[@class='fas fa-edit editList']");
		OBJECT.utility().clearField("id", "txtQGateName");
		OBJECT.utility().sendKey("id", "txtQGateName", newGateName);
		OBJECT.utility().clickElement("id", "btnSubmit");
	}

	public void deleteGate(String gateName) {
		OBJECT.utility().clickElement("xpath", "//li[@class='slide tooltip-QGList NoRework' and text()='" + gateName
				+ "']//i[@class='fa fa-trash deleteList']");
		OBJECT.utility().clickElement("id", "btnSearch");
		OBJECT.utility().clickElement("xpath", "(//span[text()='OK'])[2]");
	}

	public void ownReWork(String gateName) {
		OBJECT.utility().clickElement("xpath",
				"//li[@class='slide tooltip-QGList NoRework' and text()='" + gateName + "']//span[@class='checkmark']");
		OBJECT.utility().clickElement("xpath", "(//span[text()='OK'])[2]");
	}

	public void addVehicleType_vehicle(String vehicleType, String description) {
		OBJECT.utility().clickElement("id", "addvehicletype");
		OBJECT.utility().sendKey("id", "txtVehicleTypeName", vehicleType);
		OBJECT.utility().sendKey("id", "txtDescription", description);
		save();
	}

	public void save() {
		OBJECT.utility().clickElement("id", "btnSubmit");
	}

	public void edit_vehicle(String vehicleType) {
		OBJECT.utility().clickElement("xpath",
				"//td[text()='" + vehicleType + "']/following-sibling::td[3]/i[@class='fa fa-edit iconedit']");
	}

	public void delete_vehicle(String vehicleName) {
		OBJECT.utility().clickElement("xpath",
				"//td[text()='" + vehicleName + "']/following-sibling::td[3]/i[@class='fa fa-trash icondelete']");
	}

	public void vehicleTypeSearch(String vehicleType) throws InterruptedException {
		OBJECT.utility().sendKey("id", "txtVehTypeName", vehicleType);

		String searchVehicleType = OBJECT.utility().getText("xpath", "//td[@data-label='VehicleTypeName']");
		org.testng.Assert.assertEquals(searchVehicleType, vehicleType, "Search vehicle Type not matched...");
	}

	public void vehicleDescSearch(String Description) throws InterruptedException {
		OBJECT.utility().sendKey("id", "txtVehDescrp", Description);

		String searchDescription = OBJECT.utility().getText("xpath", "//td[@data-label='Description']");
		org.testng.Assert.assertEquals(searchDescription, Description, "Search Description not matched");
	}

	public void varientAdd(String varientName, String vehicleType) {
		OBJECT.utility().clickElement("xpath", "//span[text()='Add Variant']");
		OBJECT.utility().sendKey("id", "txtModelName", varientName);
		OBJECT.utility().clickElement("id", "AdrpVehicleType");
		OBJECT.utility().sendKey("xpath", "//button[@id='AdrpVehicleType']/following-sibling::div/div/input",
				vehicleType);
		OBJECT.utility().clickElement("xpath",
				"//button[@id='AdrpVehicleType']/following-sibling::div/ul/li[2]/label/input");
		save();
	}

	public void searchVarient(String Varient) {
		OBJECT.utility().sendKey("id", "txtModName", Varient);
		String SearchVarient = OBJECT.utility().getText("xpath",
				"//div[@id='tblModelMaster_wrapper']/table/tbody/tr/td[1]");
		org.testng.Assert.assertEquals(SearchVarient, Varient, "Search Varient not matched");
	}

	public void searchVehicleType(String varientType) {
		OBJECT.utility().sendKey("id", "txtModName", varientType);
		String SearchVarientType = OBJECT.utility().getText("xpath",
				"//div[@id='tblModelMaster_wrapper']/table/tbody/tr/td[1]");
		org.testng.Assert.assertEquals(SearchVarientType, varientType, "Search varientType not matched");
	}

	public void editVarient(String varientName, String vehicleType) {
		OBJECT.utility().clickElement("xpath",
				"//div[@id='tblModelMaster_wrapper']/table/tbody/tr/td[4]/i[@class='fa fa-edit iconedit']");
		varientAdd(varientName, vehicleType);
	}

	public void deleteVarient() {
		OBJECT.utility().clickElement("xpath",
				"//div[@id='tblModelMaster_wrapper']/table/tbody/tr/td[4]/i[@class='fa fa-trash icondelete']");
		OBJECT.utility().clickElement("xpath", "(//span[text()='OK'])[2]");
	}
}
