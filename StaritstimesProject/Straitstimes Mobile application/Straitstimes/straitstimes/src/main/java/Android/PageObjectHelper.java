package Android;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

public class PageObjectHelper {
	WebDriver helperDriver;
	final int timeOut =10;
	
	public PageObjectHelper(WebDriver driver){
		helperDriver = driver;
	}
	
	
	public void clear(WebElement element){
		if(waitVisibilityOfElement(element, timeOut)){
			element.clear();
		}
	}
	
	//wait for element to be visible for 4 seconds and get text
	public String getTextElement(WebElement element){
		try{
			if (waitVisibilityOfElement(element ,timeOut)){
				return element.getText();
			}
		}
		catch(TimeoutException e){
			return "TIMEOUT EXCEPTION";
		}
		return null;
	}	
	
	public Boolean isAllElementActive(List<WebElement> element) throws TimeoutException {
		try{
			if (waitVisibilityOfAllElements(element ,timeOut)){
				return true;
			}
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
		return false;
		
	}
	
	public Boolean isElementActive(WebElement element) throws TimeoutException {
		try{
			if (waitVisibilityOfElement(element ,timeOut)){
				return true;
			}
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
		return false;
		
	}
	
	//wait for element to be visible for t seconds and get text.
	public String getTextElement(WebElement element, int time) throws TimeoutException {
		try{
			if (waitVisibilityOfElement(element ,time)){
				return element.getText();
			}
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
		return null;
	}
	
	//wait for element to be visible for timeout seconds and writes input text
	public void writeTextInputBox(WebElement element, String input) throws TimeoutException {
		try{
			if(waitVisibilityOfElement(element,timeOut)){
				element.sendKeys(input);
			}
			}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
	}
	
	//wait for element to be visible for t seconds and writes input text.
	public void writeTextInputBox(WebElement element, String input, int time) throws TimeoutException {
		try{
			if(waitVisibilityOfElement(element,time)){
				element.sendKeys(input);
			}
			}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
	}
	
	//wait for input box element for default seconds and returns text.
		public String getTextInputBox(WebElement element) throws TimeoutException {
			try{
				if (waitVisibilityOfElement(element ,timeOut)){
					return element.getAttribute("value");
				}
			}
			catch(TimeoutException e){
				throw new TimeoutException(e);
			}
			return null;
		}
	
	//wait for input box element for t seconds and returns text.
	public String getTextInputBox(WebElement element, int time) throws TimeoutException {
		try{
			if (waitVisibilityOfElement(element ,time)){
				return element.getAttribute("value");
			}
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
		return null;
	}
	
	//wait for input box element with text auto-filled.
	public String getTextAutoInput(WebElement element, String text) throws TimeoutException {
		try{
			if(waitVisibilityOfText(element,text)){
				return element.getAttribute("value");
			}
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
		return null;
	}
	
	//wait for element for default seconds and click.
	public void clickButton(WebElement element) throws TimeoutException {
		try{
			if (waitVisibilityOfElement(element,timeOut)){
				element.click();
			}
		}
		catch(TimeoutException e ){
			throw new TimeoutException(e);
		}
	}
	
	//wait for element for t seconds and click.
	public void clickButton(WebElement element, int time) throws TimeoutException {
		try{
			if (waitVisibilityOfElement(element,time)){
				element.click();
			}
		}
		catch(TimeoutException e ){
			throw new TimeoutException(e);
		}
	}
	
	public boolean waitVisibilityOfElement(WebElement element, int time) throws TimeoutException {
		try{
			if (helperDriver == null){
				System.out.println("NULL Driver");
			}
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of element, "+element.toString());
			throw new TimeoutException(e);
		}	
	}
	
	public boolean waitVisibilityOfText(WebElement element, String text) throws TimeoutException {
		int time =timeOut;
		try{
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of element, "+element.toString());
			throw new TimeoutException(e);
		}
	}

	public boolean waitVisibilityOfText(WebElement element, String text, int time) throws TimeoutException {
		//int time =timeOut;
		try{
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
//			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("com.k7computing.android.security:id/malware_protection_last_updated_date_text"),text));
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of element, "+element.toString());
			throw new TimeoutException(e);
		}
	}

	public boolean waitInVisibilityOfText(By byElement, String text, int time) throws TimeoutException {
		//int time =timeOut;
		try{
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			//wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(byElement,text));
			//wait.until(ExpectedConditions.);
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of byElement, "+byElement.toString());
			throw new TimeoutException(e);
		}
	}
	
	public boolean waitVisibilityOfAllElements(List<WebElement> element, int time) throws TimeoutException {
		try{
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dblen")));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of element, "+element.toString());
			throw new TimeoutException(e);
		}	
	}

	public boolean waitAbscenseOfAllElements(By by, int time) throws TimeoutException {
		try{
			WebDriverWait wait = new WebDriverWait(helperDriver,time);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dblen")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		}
		catch(TimeoutException e){
			Reporter.log("Timed out Exception occurred before visibility of element, "+by.toString());
			throw new TimeoutException(e);
		}
	}

	public Boolean isTextBoxEnabled(WebElement element, int time) throws TimeoutException {
		try{
			waitVisibilityOfElement(element, time);
			return element.isEnabled();
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
	}
	
	public Boolean isTextBoxEnabled(WebElement element) throws TimeoutException {
		try{
			waitVisibilityOfElement(element, timeOut);
			return element.isEnabled();
		}
		catch(TimeoutException e){
			throw new TimeoutException(e);
		}
	}

	/*public void scrollDown(AndroidDriver<AndroidElement> scrollDriver)
	{
		RemoteWebElement rDriver;
	    ScanDevice LastElementId = new ScanDevice();
	    ScanDevice LastElementText = new ScanDevice();
		try {
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			String widId = ((RemoteWebElement) scrollDriver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
			//RemoteWebElement element = (RemoteWebElement)scrollDriver.findElementByXPath("//android.widget.ListView[contains(@resource-id,'threat_list')]/android.widget.LinearLayout");
			JavascriptExecutor js = (JavascriptExecutor) scrollDriver;
//			String widId = ((RemoteWebElement) element).getId();
//            String widId = element.getId();
//            String widId = LastElementId.toString();
			//String lastThreat = ((RemoteWebElement) element).getText();
//            String lastThreat = element.getText();
//            String lastThreat = LastElementText.toString();
//			System.out.println("Threat text last" +lastThreat);
			System.out.println("widId:  "+widId);
			scrollObject.put("text", "/storage/emulated/0/Download/eicarcom2.zip");
			scrollObject.put("element", widId);
			scrollObject.put("direction","down");
			js.executeScript("mobile: scrollTo", scrollObject);
		} catch(Exception e) {    }
	}*/

}
