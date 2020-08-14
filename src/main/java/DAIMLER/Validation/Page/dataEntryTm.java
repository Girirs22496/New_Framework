package DAIMLER.Validation.Page;

	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.sun.mail.imap.Utility;

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
		public void dataEntryTm() throws FileNotFoundException, IOException, InterruptedException {
			
			OBJECT.utility().URL("http://13.68.151.15/MatexTesting/Matrix/DETMDashboard.aspx");
			OBJECT.utility().waitUntilVisible("id", "ctl00_ContentPlaceHolder1_grdCandidate_ctl02_btnMatrixRefNo");
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_grdCandidate_ctl02_btnMatrixRefNo");
			
			String MATREFNUM = OBJECT.utility().getText("id", "ctl00_ContentPlaceHolder1_grdCandidate_ctl02_btnMatrixRefNo");
			System.out.println(MATREFNUM);
			OBJECT.utility().waitUntilVisible("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_save");
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_Middlename", "Middle Name");
			
			//Aadhar card
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_AadharApplicable", "GY");
			//Passport
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_PassportApplicable", "GY");
			//Driving License
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_DrivingLicenseApplicable", "GY");
			//PAN Card
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_PANCardApplicable", "GY");
			//Voter ID
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_VoterIDApplicable", "GY");
			//Right to Work
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_RTWCheckApplicable", "GY");
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_RTWIdType", "e7f50832-9b96-44c4-bff1-03b981e30897");
			//DB
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_DBCheckApplicable", "GY");
			
			//Drug
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_DrugCheckApplicable", "GY");
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_DrugCheckPanel", "ff92922a-53af-4850-b967-292791391855");
			
			//Medical check
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_DrugCheckMedical", "GY");
			
			//Saving
			OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_save");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String detmalert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println(detmalert);
					
			OBJECT.utility().clickElement("id","ok");
			
			//Entering Address
			OBJECT.utility().clickElement("id","__tab_ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2");
			
			OBJECT.utility().waitUntilPresent("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_save");
			
			OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_grid_ctl02_btnEdit");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_Address","Present Provided Address of " + MATREFNUM);
			
			OBJECT.utility().SendkeyDownkeyEnter("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_Pincode", "123456");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_Area_chosen");
			
			OBJECT.utility().waitUntilVisible("xpath","//li[. = 'test area']");
			OBJECT.utility().clickElement("xpath","//li[. = 'test area']");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_FromDt","Apr-2020");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_ToDt","Aug-2020");
			
			
			OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_save");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
						
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String deadrsalert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println("Presen adrs " +deadrsalert);
					
			OBJECT.utility().clickElement("id","ok");
	
			
			
			
			
			
			
			
		}
		
		

		public void Personal() {
			
			//Aadhar Card
//			ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_AadharApplicable
			
		}
	
	
	
	
	
	
	}
