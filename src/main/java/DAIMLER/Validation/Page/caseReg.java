package DAIMLER.Validation.Page;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import DAIMLER.Validation.Base.Object;
import DAIMLER.Validation.Utility.UtilValues;

public class caseReg {
	private WebDriver driver;
	ExtentTest logger;
	Object OBJECT;

	public caseReg(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);

}
	
	
	public void caseReg() throws FileNotFoundException, IOException, InterruptedException {
		OBJECT.utility().URL("http://13.68.151.15/MatexTesting/Matrix/CRTCaseRegistration.aspx");
//		OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_txtClientName", "demo checking bsv");
		OBJECT.utility().SendkeyDownkeyEnter("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_txtClientName", "Demo checking BSV - Demo Client");
		
		
		
		OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
		
		Thread.sleep(500);
		
		OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_TypeofMedium", "SC");
		OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_ddlSubGroup", "cea89c36-38ea-458c-9ab1-12199c91100e");
		
//		OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_Case_CandidateName", "Giridharan");
		
		OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_Case_CandidateName", OBJECT.utilValues().FirstName());
		
		OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_Case_Sub_group", "HR2");
		
		OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_CaseRegistrationUC_Case_Typeofemployee", "capgemini employee type");
		Thread.sleep(1000);
		
		OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_CaseRegistrationUC_grdSubcheck_ctl02_chkSubcheckSelect");
		OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_CaseRegistrationUC_btnRegisterCase");
		
		OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
		
		OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
		
		String alert = OBJECT.utility().getText("xpath", "//div[@class='m_content']");
		System.out.println(alert);
		
		OBJECT.utility().clickElement("id","ok");
		
		
		
		
		
		
		}
	
}