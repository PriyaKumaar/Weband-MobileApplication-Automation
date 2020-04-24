package com.straitstimeswebproj.testpages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	int statusCode;
	WebDriver driver; //Driver initialization
	
public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public int getIframeCount() // For advertisement pop up get the frame id to handle advertisement pop up
	{
		try{
			return driver.findElements(By.cssSelector("iframe")).size();
		}
		catch(Exception e){
			return 0;
		}
		
	}
public void clickAdClose(int size) //Function declaration for Adclose
{
		for(int i=0;i<=size;i++){
			driver.switchTo().frame(i);
			System.out.println(i);
			if(isElementPresent(By.id("celtra-object-118"))){
			System.out.println("Frame element displayed");
			driver.findElement(By.id("celtra-object-118")).click();						
			driver.switchTo().defaultContent();
			break;
			}
driver.switchTo().defaultContent();
}
}

public void ClickLogin() //Function declaration for Login button in main page
{
		System.out.println("login");
		By login= By.xpath("//li[@class='nav-login']/a"); 
		clickJSElement(driver,driver.findElement(login));
		System.out.println("login success");
		
}
public static boolean clickJSElement(WebDriver driver,WebElement element) //Javascriptor executor to find elemnets
{ 

	try{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			return true;
		
		}
		catch (Exception e){
			return false;
		}
		
}
protected boolean isElementPresent(By by) //Boolean function to find the elements
{
        
	try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
  }
public void click_on_main_article() throws Throwable  //Function to check for click on main article
{
	System.out.println("Main article");
	Thread.sleep(30000);
	String homePageMainStoryURL = driver.findElement(By.cssSelector(".panel-display>div:nth-of-type(4) .pane-articles-topstory-nodequeue div[data-vr-contentbox] .pull-left .file.file-image img")).getAttribute("src");	
	System.out.println(homePageMainStoryURL);
	driver.findElement(By.cssSelector(".panel-display>div:nth-of-type(4) .pane-articles-topstory-nodequeue div[data-vr-zone='Top Stories 0'] .block-link")).click();
}
public void getResponseCode() throws MalformedURLException, IOException{
    String Currenturl=driver.getCurrentUrl();
    Assert.assertTrue(Currenturl.startsWith("https://www.straitstimes.com/singapore/"));
    System.out.println(Currenturl);

}
    
       
}


    


