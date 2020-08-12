package DAIMLER.Validation.Base;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import DAIMLER.Validation.Page.extraPage;
import DAIMLER.Validation.Page.feedBack;
import DAIMLER.Validation.Page.homePage;
import DAIMLER.Validation.Page.loginPage;
import DAIMLER.Validation.Utility.UtilValues;
import DAIMLER.Validation.Utility.Utility;

import DAIMLER.Validation.Page.caseReg;

public class Object {

	WebDriver driver;
	ExtentTest logger;
	WebDriverWait wait;

	public Object(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		this.wait = new WebDriverWait(this.driver, 50);
	}

	public Screencasting screencasting() throws IOException, AWTException {
		Screencasting SCRCAS = new Screencasting(null, null, null, null, null, null, null, null);
		return SCRCAS;
	}

	public Utility utility() {
		Utility Util = new Utility(driver, logger);
		return Util;
	}

	public UtilValues utilValues() {
		UtilValues UtilVal = new UtilValues(driver, logger);
		return UtilVal;
	}

	public loginPage loginPage() {
		loginPage logPage = new loginPage(driver, logger);
		return logPage;
	}

	public DAIMLER.Validation.Page.dataEntryTl dataEntryTl() {
		DAIMLER.Validation.Page.dataEntryTl detl = new DAIMLER.Validation.Page.dataEntryTl(driver,logger);
		return detl;
	}
	
	
	
	public homePage homePage() {
		homePage hmepage = new homePage(driver, logger);
		return hmepage;
	}
	
	
	public DAIMLER.Validation.Page.dataEntryTm dataEntryTm() {
		DAIMLER.Validation.Page.dataEntryTm detm = new DAIMLER.Validation.Page.dataEntryTm(driver,logger);
		return detm;
		
	}
	
	
	public extraPage extraPage() {
		extraPage extrPage = new extraPage(driver, logger);
		return extrPage;
	}
	
	public feedBack feedBack() {
		feedBack feedBack = new feedBack(driver, logger);
		return feedBack;
	}
	
	public caseReg caseReg() {
		caseReg caseregister = new caseReg(driver, logger);
		return caseregister;
	}
	
}
