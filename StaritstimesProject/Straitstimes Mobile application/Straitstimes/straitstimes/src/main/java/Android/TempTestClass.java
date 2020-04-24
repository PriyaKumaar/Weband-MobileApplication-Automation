package Android;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

//@Listeners({TestListener.class})
public class TempTestClass extends AppSetup {
private AppSetup appSetup;


    @BeforeClass
    public void initialize(){
        try {
            AppSetup.setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 1)
    public void InstallApp(){
        appSetup = new AppSetup();
        appSetup.searchAndInstall();

    }
    @Test (priority = 2)
    public void UseApp(){
        appSetup.openApp();
    }

    @Test (priority = 3)
    public void GotoLatest(){
        appSetup.gotoHomePage();
    }

    @Test (priority = 3,enabled = false)
    public void Uninstall(){
        appSetup.unistallApp();
    }




}
