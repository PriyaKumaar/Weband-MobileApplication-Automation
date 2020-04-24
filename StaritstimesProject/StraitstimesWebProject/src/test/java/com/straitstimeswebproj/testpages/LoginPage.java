package com.straitstimeswebproj.testpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;

@FindBy(id="j_username") //Find element of emailtextbox using id
private WebElement emailTextBox;

@FindBy(id="j_password") //Find element of Password using id
private WebElement passwordBox;	


@FindBy(xpath="//*[@id='loginForm']/button") //Find element of login button using Xpath
private WebElement loginBtn;	

@FindBy(xpath="//li[@class='nav-logout']/a") //Find element of logout button using Xpath
private WebElement logout;	


@FindBy(className="text-danger") //Find element of error message
private WebElement errorMsgTxt;

public LoginPage(WebDriver driver)  //Driver initialization for driver
	{
	    PageFactory.initElements(driver, this);
	}
	
public void login() throws InterruptedException //Login using valid credentials
{
		
	System.out.println("Enters into login page");
	Thread.sleep(10000);
		if(emailTextBox.isDisplayed())
			emailTextBox.clear();
			emailTextBox.sendKeys("digitaltest9");
		if(passwordBox.isDisplayed())
			passwordBox.clear();
			passwordBox.sendKeys("Sphdigital1");
}
public void clickOnSignIn()  //Declaration of function for Sign in!
{
		if(loginBtn.isDisplayed())
			loginBtn.click();
			System.out.println("Login success");
}
				
public void clickOnlogout() throws InterruptedException //Declaration of function for logout
{
		
	System.out.println("logout");
	Thread.sleep(30000);
	logout.click();
	System.out.println("logout success)");
	
}
}
