package DAIMLER.Validation.Page;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import DAIMLER.Validation.Base.Object;


public class dataEntryTl {
	private WebDriver driver;
	ExtentTest logger;
	Object OBJECT;

	public dataEntryTl(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		OBJECT = new Object(driver, logger);

}
	public void dataentrytl() throws InterruptedException, FileNotFoundException, IOException
	{
	
	OBJECT.utility().URL("http://13.68.151.15/MatexTesting/Matrix/AssignCases.aspx");
	
	
	//td[contains(.,'demosaa')]
	OBJECT.utility().waitUntilPresent("id","ctl00_ContentPlaceHolder1_ddTLList");
	
	OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_ddTLList", "60cfb21f-188f-484a-a903-ee3ccea07e35");
	
	OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
	
	OBJECT.utility().waitUntilPresent("id","ctl00_ContentPlaceHolder1_grdCRT_ctl02_chkCRTSelect");
	
	OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_grdCRT_ctl02_chkCRTSelect");
	
	String Matrefnum = OBJECT.utility().FindElement("xpath", "//*[@id=\"ctl00_ContentPlaceHolder1_grdCRT\"]/tbody/tr[2]/td[4]").getText();
	System.out.println("Case Ref Number is "+ Matrefnum);
	
	
	OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_ddlTM", "60cfb21f-188f-484a-a903-ee3ccea07e35");
	
	
    OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_btnAssign");
	
	OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
//	
	OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
//	
	String Detlalert = OBJECT.utility().getText("xpath", "//div[@class='m_content']");
	System.out.println(Matrefnum+ " " + Detlalert);
//	
	OBJECT.utility().clickElement("id","ok");
//	

}
}