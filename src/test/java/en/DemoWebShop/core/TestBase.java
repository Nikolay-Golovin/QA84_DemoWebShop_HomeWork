package en.DemoWebShop.core;

import de.DemoWebShop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase extends ApplicationManager {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    public TestBase(String browser) {
        super(browser);
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp()
    {
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown()  {
        app.stop();
    }

}



