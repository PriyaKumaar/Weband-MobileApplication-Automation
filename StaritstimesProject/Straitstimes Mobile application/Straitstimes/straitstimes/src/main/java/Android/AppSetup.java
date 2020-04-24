package Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppSetup {

    static WebDriver Sdriver;
    static AndroidDriver driver;
    private PageObjectHelper helper;

    @FindBy(xpath = "//android.widget.Button[@text='OPEN' and @index='1']")
    WebElement openButton;
    @FindBy(id = "com.buuuk.st:id/btn_tnc_ok")
    WebElement agree;

    //    @Step("Initialize the capabilities")
    public static void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
// Created object of DesiredCapabilities class.

        capabilities.setCapability("deviceName", "076320f713cc9179");
// Set android deviceName desired capability. Set your device name.

//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.ANDROID);
// Set BROWSER_NAME desired capability. As we are running on Android Emulator, It's Android.

        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
// Set Android's OS VERSION @ desired capability.

        capabilities.setCapability("platformName", "Android");
// Set platformName desired capability to Android.

        capabilities.setCapability("noReset", true);

        capabilities.setCapability("fullReset", false);

//        capabilities.setCapability("app", app.getAbsolutePath());


        capabilities.setCapability("appPackage", "com.android.vending");
// Set your application's package.

        capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
// Set your application's MainActivity.

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Sdriver = driver;
// Create driver, set the Appium Server details.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void searchAndInstall() {
        PageFactory.initElements(driver, this);
        helper = new PageObjectHelper(driver);
        //Clicking Search box in Google Play
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Entering Package name in text field
        driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys("com.buuuk.st");
//    driver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER );
        driver.pressKeyCode(AndroidKeyCode.ENTER);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Clicking Searched app
        driver.findElement(By.xpath("//android.widget.TextView[@text='The Straits Times for Smartphone' and @index='2']")).click();
//        driver.findElement(By.name("The Straits Times for Smartphone")).click();
        //Clicking INSTALL button
        driver.findElement(By.xpath("//android.widget.Button[@text='INSTALL' and @index='0']")).click();
        //Waiting for app to install
//        driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
        helper.waitVisibilityOfElement(openButton, 180);
    }
public void openApp(){
    PageFactory.initElements(driver, this);
    helper = new PageObjectHelper(driver);
//        driver.startActivity("com.buuuk.st","com.sph.straitstimes.views.activities.SplashActivity");
        //Opening the App
        driver.findElement(By.xpath("//android.widget.Button[@text='OPEN' and @index='1']")).click();

        helper.waitVisibilityOfElement(agree,5);

        //Clicking Agree
        driver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok")).click();

        //Swiping Tutor
        for (int i = 1; i < 2; i++) {
            WebElement contact = driver.findElement(By.id("com.buuuk.st:id/layout_st_bg"));
            int wide = contact.getSize().width;
            int hgt = contact.getSize().height;
            int startx = (int) (wide * (0.8));
            int endx = (int) (wide * (0.1));
            int starty = hgt / 2;
            int endy = hgt / 2;

            /*Swiping tutor Page*/
            driver.swipe(startx, starty, endx, starty, 500);

            /*Waiting between Swipes*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        //Clicking Skip
        driver.findElement(By.id("com.buuuk.st:id/skip")).click();
        // Waiting for home screen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Tapping Sandwich Menu
        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        //Tapping Login Button
        driver.findElement(By.id("com.buuuk.st:id/tv_login")).click();
        //Entering Login credentials
        driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_username")).click();
        driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_username")).sendKeys("digitaltest9");
        //Entering Password
        driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_password")).click();
        driver.findElement(By.id("com.buuuk.st:id/et_ldap_login_password")).sendKeys("Sphdigital1");
        //Tapping Login
        driver.findElement(By.id("com.buuuk.st:id/btn_ldap_login_continue")).click();


    }

    public void gotoHomePage(){
        //invoking App
//        driver.startActivity("com.buuuk.st","com.sph.straitstimes.views.activities.SplashActivity");
//        //Tapping Sandwich Menu
//        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
//        //Clicking Home Page
//        driver.findElement(By.id("com.buuuk.st:id/iv_home")).click();
        //Finding"LATEST" tab and clicking it
        driver.findElement(By.xpath("//android.widget.TextView[@text='LATEST' and @index='0']")).click();
        //Waiting for page to Load

    }
public void unistallApp(){
    PageFactory.initElements(driver, this);
    helper = new PageObjectHelper(driver);
    Runtime runtime = Runtime.getRuntime();
    try {
        runtime.exec("cmd.exe /c start cmd.exe /k \"adb uninstall com.buuuk.st\"");
        Thread.sleep(2000);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
