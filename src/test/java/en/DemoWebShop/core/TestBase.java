package en.DemoWebShop.core;

import de.DemoWebShop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase extends ApplicationManager {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

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

    @BeforeMethod
    public void startTest() {
        logger.info("Start test");
    }
    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }

}



