package DAIMLER.Validation.TestNG;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import DAIMLER.Validation.Base.Object;

public class FlowTestng {

	public WebDriver driver;
	WebDriverWait wait;
	ExtentHtmlReporter reporter;
	ExtentTest logger;
	ExtentReports extent;
	String nodeURL;
	DAIMLER.Validation.Base.Object OBJECT;

	String sFileName = "C:\\Users\\QTPL-08\\Downloads\\automatedqfl-master\\automatedqfl-master\\loadReport\\SeleniumEasy.har";
	public BrowserMobProxy proxy;

	@BeforeSuite
	public void beforeSuit() {

		reporter = new ExtentHtmlReporter("./Report/Login.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Automation Report");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setup(Method method) throws Exception {
		logger = extent.createTest(method.getName());
		logger.pass(method.getName() + " Started");
		logger.assignAuthor("Manikandan");

		OBJECT = new Object(driver, logger);
	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws FileNotFoundException, MalformedURLException, IOException {

//		proxy = new BrowserMobProxyServer();
//		proxy.start(0);
//
//		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions Headless = new ChromeOptions();
		Headless.setHeadless(false);

//		driver = new ChromeDriver(capabilities);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
//		Dimension d = new Dimension(1213, 997);
//		driver.manage().window().setSize(d);
		driver.manage().deleteAllCookies();

//		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//		proxy.newHar("Performance");
	}
	
	@Test()
	public void test() throws FileNotFoundException, IOException, InterruptedException {
		
//		for (int i = 0; i < 20 ; i++)
//		{
		OBJECT.loginPage().loginPage();
		OBJECT.caseReg().caseReg();
		OBJECT.dataEntryTl().dataentrytl();
		OBJECT.dataEntryTm().dataEntryTm();
//		i++;
		
		//code by giri
	}
//	}
	
	@Test(enabled = false)
	public void testCase_00() throws FileNotFoundException, IOException {
		OBJECT.loginPage().loginPage();
		OBJECT.homePage().homePage();
		OBJECT.homePage().plantSelect("PABCO Co., Ltd.");		
	}
	
	@Test(dependsOnMethods= {"testCase_00"}, enabled = false)
	public void testCase_01() throws FileNotFoundException, IOException, ExecutionException, InterruptedException {
		OBJECT.homePage().report();
		OBJECT.homePage().extras();
		OBJECT.homePage().QFLfeedback();
		OBJECT.homePage().progressMonitor();
	}
	
	@Test(dependsOnMethods= {"testCase_00"}, enabled = false)
	public void testCase_02() throws InterruptedException {
		OBJECT.homePage().extras();
		OBJECT.extraPage().QGateMaster();
		OBJECT.extraPage().wingLine();
	}
	
	@Test(dependsOnMethods= {"testCase_00"}, enabled = false)
	public void testCase_03() throws InterruptedException {
		OBJECT.homePage().QFLfeedback();
		OBJECT.feedBack().QGate("wing gate 1");
		OBJECT.feedBack().vehicleType("HDT");
		OBJECT.feedBack().Varient("Wing");
		OBJECT.feedBack().VINno("001");
		OBJECT.feedBack().Customer("manikandan");
		OBJECT.feedBack().Search();
		Thread.sleep(900);
		OBJECT.feedBack().totalCheckItemTab();
		OBJECT.feedBack().OkTab();
		OBJECT.feedBack().notOkTab();
		OBJECT.feedBack().SkippedTab();
		OBJECT.feedBack().PendingTab();	
		OBJECT.feedBack().selectAction();
	}
	

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

	@AfterMethod
	public String tearDown(ITestResult result, Method method) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			OBJECT.utility().screenShot(driver, result.getName());

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip(result.getThrowable().getMessage());
		}
		return method.getName();
	}

	@AfterTest
	public void tearDown() throws IOException {

		extent.flush();
//	driver.quit();
//		String url = OBJECT.utility().CurrentDir() + "/Report/Login.html";
//		File htmlFile = new File(url);
//    	Desktop.getDesktop().browse(htmlFile.toURI());	

		// get the HAR data
//		Har har = proxy.getHar();

		// Write HAR Data in a File
//		File harFile = new File(sFileName);
//		try {
//			har.writeTo(harFile);
//		} catch (IOException ex) {
//			System.out.println(ex.toString());
//			System.out.println("Could not find file " + sFileName);
//		}

//		if (driver != null) {
//			proxy.stop();
//			driver.close();
//		}
	}
}
