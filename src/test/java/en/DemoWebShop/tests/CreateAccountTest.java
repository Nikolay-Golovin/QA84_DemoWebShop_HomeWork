package en.DemoWebShop.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class CreateAccountTest extends TestBase {


    @Test
    public void newUserRegisterPositiveTest(){
        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"), "John");
        type(By.name("LastName"), "Doue");
        type(By.name("Email"), "JohnTase2satDoue@mail.de");
        type(By.name("Password"), "123Q12a!");
        type(By.name("ConfirmPassword"), "123Q12a!");
        click(By.name("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Log out']")));



    }
    @Test
    public void ExistedUserRegisterNegativeTest(){
        click(By.cssSelector("*[href='/register']"));
        type(By.name("FirstName"), "John");
        type(By.name("LastName"), "Doue");
        type(By.name("Email"), "JohnTesatDoue@mail.de");
        type(By.name("Password"), "123Q12a!");
        type(By.name("ConfirmPassword"), "123Q12a!");
        click(By.name("register-button"));
//        Assert.assertTrue(isElementPresent(By.cssSelector(".validation-summary-errors")));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='The specified email already exists']")));



    }

}
