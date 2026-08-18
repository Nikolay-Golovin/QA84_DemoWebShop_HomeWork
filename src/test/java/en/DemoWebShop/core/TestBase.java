package en.DemoWebShop.core;

import ch.qos.logback.core.status.Status;
import de.DemoWebShop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

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
    public void startTest(Method method){
        logger.info("Start test {}",method.getName());
    }
    @AfterMethod //ITestResult интерфейс в тестовом фреймворке TestNG, который содержит всю информацию о результатах выполнения конкретного тестового метода.


    public void stopTest(ITestResult result){

        if (result.isSuccess()){
            logger.info("PASSED -->> {}",result.getMethod().getMethodName());
        }else {
            logger.error("FAILED -->>{}. Screenshot  -->> {}",
                    result.getMethod().getMethodName(),
                    app.getUserHelper().takeScreenshot());
        }
logger.info("Stop test");
        System.out.println("**********************");
}}



