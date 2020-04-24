package steptest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.straitstimeswebproj.testpages.HomePage;
import com.straitstimeswebproj.testpages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainUserSteps {

WebDriver driver;

	
@Given("^the user in main page$") 
public void the_user_in_main_page() throws Throwable //Main page declaration
{
	System.setProperty("webdriver.chrome.driver","C:/Users/priya/Driver1/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.straitstimes.com/");
	Thread.sleep(10000);
}

@When("^user  click on login$")
public void user_click_on_login() throws Throwable//calls the functions of login and ad pop up in home page
{
	HomePage homepage=new HomePage(driver); 
	int iFrameCnt = homepage.getIframeCount(); //frame count
	System.out.println(iFrameCnt); //print the frame count
	homepage.clickAdClose(iFrameCnt); //close the ad pop up
	System.out.println("advertisment pop up closed");	
	homepage.ClickLogin(); //user clicks login button
}
	

@When("^verify user has been logged in and logout$")
public void verify_user_has_been_logged_in_and_logout() throws Throwable  //calls the function login user with valid credentials in loginpage
{
	LoginPage loginpage=new LoginPage(driver);
	loginpage.login();
	loginpage.clickOnSignIn();
	loginpage.clickOnlogout();
}

@Then("^verify main article has picture/video and click on main article$")
public void verify_main_article_has_picture_video_and_click_on_main_article() throws Throwable //calls the functionality of logout in login page
{
	HomePage homepage=new HomePage(driver); 
	homepage.click_on_main_article();

}
		
@Then("^verify page has been navigated to main article$")
public void verify_page_has_been_navigated_to_main_article() throws Throwable {
    HomePage homepage=new HomePage(driver);
    homepage.getResponseCode();
    
}

}
	