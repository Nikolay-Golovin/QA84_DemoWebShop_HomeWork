package en.DemoWebShop.tests;
import en.DemoWebShop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    public CreateAccountTest(String browser) {
        super(browser);
    }

    @Test
    public void newUserRegisterPositiveTest(){
        app.getUserHelper().clockOnRegisterLick();
        app.getUserHelper().fillLoginRegisterForm(new de.DemoWebShop.model.User().setEmail( app.getUserHelper().
                newEmail()).
                setPassword("123Q12a!").
                setConfirmPassword("123Q12a!").
                setFirstName("John").
                setLastName("Doue"));
        app.getUserHelper().clickOnRegisterButton();
        Assert.assertTrue( app.getUserHelper().isLogOutButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        app.getUserHelper().clockOnRegisterLick();
        app.getUserHelper().fillLoginRegisterForm(new de.DemoWebShop.
                model.User().
                setEmail("JohnTesatDoue@mail.de").
                setPassword("123Q12a!").
                setConfirmPassword("123Q12a!").
                setFirstName("John").
                setLastName("Doue"));
        app.getUserHelper().clickOnRegisterButton();
        Assert.assertTrue( app.getUserHelper().isAlreadyExistsPresent());
    }
}
