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
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_Middlename", OBJECT.utilValues().LastName());
			//Gap
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_GapCount", "2");
			
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
			
			
			
			
			//Criminal
			
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_NotApplicable", "BO");
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			//Court
			
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_ClientAddr_CtNotApplicable", "GY");
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");			
			
			OBJECT.utility().clickElement("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel2_CandidateAddress1_save");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
						
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String deadrsalert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println("Presen adrs " +deadrsalert);
					
			OBJECT.utility().clickElement("id","ok");
			
			//Education
			
			
			OBJECT.utility().clickElement("id", "__tab_ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_CdtEdu_EducationType", "10");
			
			OBJECT.utility().SendkeyDownkeyEnter("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_Name", "demo school");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_DegreeName", OBJECT.utilValues().FullName());
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_StudentID", "511913109");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_StartDt", "Jan-2020");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_EndDt", "Aug-2020");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_PassYear", "Aug-2020");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_DegreeType", "SB");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_NameofDegree", OBJECT.utilValues().School());
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_MajorSubject", "Maths");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_Graduated", "GY");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_ProgramType", "FD");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_CGPA", "8.7");
			
			OBJECT.utility().sendKey("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_ClassObtained", "S");
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_ClientEdu_NotApplicable");
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel3_CandidateEducation1_save");
			
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String deEdualert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println("Edu 10th " + deEdualert);
					
			OBJECT.utility().clickElement("id","ok");
			
			//Employment
			
			OBJECT.utility().clickElement("id","__tab_ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_CdtCompany_Type", "Emp 1(Latest)");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().SendkeyDownkeyEnter("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_CmpName", "Demo employer 1");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_CmpAddr",OBJECT.utilValues().Address());
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_Position","Software Test Engineer");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_FromDt","14-Mar-2018");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_ToDt","14-Aug-2020");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_EmpCode","362");
			
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_EmplType","P");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_LastSalary","15000");
					
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_CurrencyType","IN");
			
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_SalType","M");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_ReasonLeave","Carrer Growth");
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_ClientEmpl_NotApplicable");
			
			OBJECT.utility().SelectOptionByValue("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_CdtCompany_FullTime_PartTime","2");	
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel4_CandidateEmployment1_save");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String deEmpalert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println("Emp 1 Latest " + deEmpalert);
					
			OBJECT.utility().clickElement("id","ok");
			
			//Reference
			
			OBJECT.utility().clickElement("id", "__tab_ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_ReferencesCheckType", "Professional");
			
			OBJECT.utility().SelectOptionByValue("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_Type", "Ref 1");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_RepName", OBJECT.utilValues().FirstName());
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_RepDesig", "Test Lead");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_RepMobile", "+91");
						
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_RepMobile1", "1234567890");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_RepEmail", "testing@test.com");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_OrgName", "Kadamba");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_OrgAddr", "57,Citdel 3rd Floor,Dr.Radha Krishnan salai, Mylapore");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_HRName", "Thomas");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_HRContact", "1234567890");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_HRDesignation", "Senior HR");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_ContDt", "01-Aug-2020");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_HREmail", "hr@test.com");
			
			OBJECT.utility().sendKey("id","ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_CanKnown", "Friend");
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_ClientRef_NotApplicable");
			
			OBJECT.utility().clickElement("id", "ctl00_ContentPlaceHolder1_TabContainer1_TabPanel5_CandidateReference1_save");
			
			OBJECT.utility().waitUntilInVisible("xpath", "//div[@class='loader']");
			
			OBJECT.utility().waitUntilPresent("xpath","//div[@class='m_content']");
			String deRefalert = OBJECT.utility().getText("xpath","//div[@class='m_content']");
			System.out.println("Ref 1 " + deRefalert);
					
			OBJECT.utility().clickElement("id","ok");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
			
			
			
			
			
			
			
		}
		
		

		public void Personal() {
			
			//Aadhar Card
//			ctl00_ContentPlaceHolder1_TabContainer1_TabPanel1_CandidateHome1_Candidate_AadharApplicable
			
		}
	
	
	
	
	
	
	}
