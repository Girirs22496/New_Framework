package DAIMLER.Validation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.support.ui.FluentWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Utility {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public ExtentTest logger;
	public static Set allCookies;
	public Wait<WebDriver> wait;

	String propertyPath = "/home/kadamba/Documents/Git/daimler/src/resource/java/DAIMLER/Validation/Resource/config.properties";

	@SuppressWarnings("deprecation")
	public Utility(WebDriver d, ExtentTest logger) {
		this.driver = d;
		this.logger = logger;
		jse = (JavascriptExecutor) driver;

		try {
			wait = new FluentWait<WebDriver>(driver).withTimeout(600, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
		} catch (Exception e) {
			logger.log(Status.ERROR, "Error in Fluent Wait " + e);
		}
	}

	public void URL(String URL) throws FileNotFoundException, IOException {
		driver.get(URL);
		logger.log(Status.INFO, "URL is Passed " + URL);
	}

	public String getTitle() {
		String title = driver.getTitle();
		logger.log(Status.PASS, "getting page title as  " + title);
		return title;
	}

	public Set<Cookie> getcookies() {
		return driver.manage().getCookies();
	}

	public void importcookies(Set<Cookie> allcookie) {
		for (Cookie cookie : allcookie) {
			driver.manage().addCookie(cookie);
		}
	}

	public void CloseBrowser() {
		driver.close();
		logger.log(Status.PASS, "browser closed ");
	}

	public void closeallbrowsers() {
		driver.quit();
		logger.log(Status.PASS, "all browsers are closed ");
	}

	private By locatorValue(String locatorType, String value) {
		By by;
		switch (locatorType) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "className":
			by = By.className(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		case "tagName":
			by = By.tagName(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public String CurrentDir() {
		final String dir = System.getProperty("user.dir");
		return dir;
	}

	public void clearField(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement clearField = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		clearField.clear();

		logger.log(Status.INFO, "Value clear in this " + webelement + " Element");
	}
	
	public void sendKey(String webelementType, String webelement, String Values) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement SendKey = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		SendKey.sendKeys(Values);

		logger.log(Status.INFO, "Value " + Values + " is Passed to this " + webelement + " Element");
	}

	public void sendKeyEnter(String webelementType, String webelement, String Values) throws InterruptedException {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement SendKeyEntr = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		SendKeyEntr.sendKeys(Values);
		SendKeyEntr.sendKeys(Keys.ENTER);

		logger.log(Status.INFO, "Value " + Values + " is Passed to this " + webelement + " Element");
	}

	public void SendkeyDownkeyEnter(String webelementType, String webelement, String Values) throws InterruptedException {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement SendKeyEntr = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		SendKeyEntr.sendKeys(Values);
		
		Thread.sleep(3000);
		
		SendKeyEntr.sendKeys(Keys.DOWN);
		SendKeyEntr.sendKeys(Keys.ENTER);

		logger.log(Status.INFO, "Value " + Values + " is Passed to this " + webelement + " Element");
	}
	
	public void clickElement(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement SendKey = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		jse.executeScript("arguments[0].scrollIntoView(true);", SendKey);
		SendKey.click();

		logger.log(Status.INFO, "Element " + locator + " is Clicked");
	}

	public void doubleClick(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.doubleClick(ele).build().perform();
		logger.log(Status.PASS, "double clicking in element : " + locator);
	}

	public void mouseOver(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator));
		action.build().perform();
		logger.log(Status.PASS, "performing mouse over on :" + locator);
		action = null;
	}

	public void switchWindow(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index).toString());
	}

	public void SwitchDefault() {
		driver.switchTo().defaultContent();
		logger.log(Status.PASS, "switching to default frame");
	}

	public void SwitchFramebyIndex(int index) {
		driver.switchTo().frame(index);
		logger.log(Status.PASS, "switching frame by index " + index);

	}

	
	public boolean isSelected(String webelementType, String webelement) {
		By locator = locatorValue(webelementType, webelement);
		return driver.findElement(locator).isSelected();
	}

	public boolean isDisplayed(String webelementType, String webelement) {
		By locator = locatorValue(webelementType, webelement);
		return driver.findElement(locator).isDisplayed();
	}

	public boolean isEnabled(String webelementType, String webelement) {
		By locator = locatorValue(webelementType, webelement);
		return driver.findElement(locator).isEnabled();
	}

	public void scrollToElement(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

		logger.log(Status.INFO, "Page scroll to this " + webelement + " Element");
	}

	public void documentUpload(String webelementType, String webelement, String Values) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement docUpload = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		docUpload.sendKeys(Values);

		logger.log(Status.INFO, "Document is Uploaded");
	}

	public String getText(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String Text = element.getText();

		logger.log(Status.INFO, "Text " + Text + " is get from this " + webelement + " Element");
		return Text;
	}

	public void AllElementPresent(String webelementType, String webelement, int Time) {

		By locator = locatorValue(webelementType, webelement);
		new WebDriverWait(driver, Time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public int elementCount(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		int Temp = driver.findElements((locator)).size();

		logger.log(Status.INFO, "Given Element " + webelement + " Count is :" + Temp);
		return Temp;
	}

	public WebElement FindElement(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		WebElement WEB_ELE = driver.findElement(locator);
		logger.log(Status.INFO, "Element " + webelement + " is Find");
		return WEB_ELE;
	}

	public List<WebElement> findWebElements(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		List<WebElement> WEB_ELE = driver.findElements(locator);
		logger.log(Status.INFO, "Element " + webelement + " is Find");
		return WEB_ELE;
	}

	public boolean elementVisible(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(locator).isDisplayed();
		logger.log(Status.INFO, "Element " + webelement + " is Visible");
		return true;
	}

	public boolean elementEnabled(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(locator).isEnabled();
		logger.log(Status.INFO, "Element " + webelement + " is Enable");
		return true;
	}

	public boolean elementSelected(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(locator).isSelected();
		logger.log(Status.INFO, "Element " + webelement + " is Selected");
		return true;
	}

	public boolean waitUntilVisible(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		logger.log(Status.INFO, "Wait for this " + webelement + " Element Visibility");
		return true;
	}

	public boolean WaitForElementDisapper() {
		try {
			while (true) {
				try {
					if (driver.findElement(By.xpath("//div[@class='loader']")).isDisplayed()) {
						Thread.sleep(2000);
					}
				} catch (Exception NoSuchElementException) {
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean waitUntilInVisible(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		logger.log(Status.INFO, "Wait for this " + webelement + " Element Visibility");
		return true;
	}

	public boolean waitUntilPresent(String webelementType, String webelement) {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		logger.log(Status.INFO, "Wait for this " + webelement + " Element Presents");
		return true;
	}

	public void selctOptionByIteration(String webelementType, String webelement, String Value) {

		By locator = locatorValue(webelementType, webelement);

		WebElement Values = driver.findElement(locator);
		List<WebElement> options = Values.findElements(locator);

		for (WebElement option : options) {
			if (Value.equals(option.getText()))
				option.click();
		}
	}

	public void selectOption(String webelementType, String webelement, String Values) throws InterruptedException {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement Option = driver.findElement(locator);
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(Option));
		Option.click();

		Select select = new Select(Option);
		select.selectByVisibleText(Values);
		logger.log(Status.INFO, "Option " + Values + " is Select from the Element" + webelement);
	}

	public void SelectOptionByValue(String webelementType, String webelement, String Values)
			throws InterruptedException {

		By locator = locatorValue(webelementType, webelement);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement Option = driver.findElement(locator);
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(Option));
//		Option.click();

		Select select = new Select(Option);
		select.selectByValue(Values);
		logger.log(Status.INFO, "Option " + Values + " is Select from the Element" + webelement);
	}

	public String propertyData(String propertyValue) throws FileNotFoundException, IOException {
		Properties Property = new Properties();
		Property.load(
				new FileInputStream(CurrentDir() + "/src/resource/java/DAIMLER/Validation/Resource/config.properties"));
		String InputData = Property.getProperty(propertyValue);
		return InputData;
	}

	public String screenShot(WebDriver driver, String method) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String ProPath = CurrentDir() + "Report/ScreenShot/";
		String path = (ProPath + method + ".png");
		FileUtils.copyFile(src, new File(path));

		try {
			logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("file://" + path).build());
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
}