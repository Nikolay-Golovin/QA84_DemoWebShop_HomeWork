package en.DemoWebShop.tests;
import de.DemoWebShop.data.UserData;
import de.DemoWebShop.model.User;
import en.DemoWebShop.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.foreign.PaddingLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {


    public CreateAccountTest(String browser) {
        super(browser);
    }

    @Test
    public void newUserRegisterPositiveTest(){
        app.getUserHelper().clockOnRegisterLick();
        app.getUserHelper().fillLoginRegisterForm(new de.DemoWebShop.model.User().setEmail( app.getUserHelper().
                newEmail()).
                setPassword(UserData.PASSWORD).
                setConfirmPassword(UserData.CONPASSWORD).
                setFirstName("John").
                setLastName("Doue"));
        app.getUserHelper().clickOnRegisterButton();
        Assert.assertTrue( app.getUserHelper().isLogOutButtonPresent());
    }

    @Test(dataProvider = "userNameDataFromCSV")
    public void existedUserRegisterNegativeTest(String firstName, String lastName)
    // тут мы тип просто добовляем две переменные которые считываються с лево на права там с файла в массив . со списка лиск читаем именна

    {

        app.getUserHelper().clockOnRegisterLick();
        app.getUserHelper().fillLoginRegisterForm(new de.DemoWebShop.
                model.User().
                setEmail(UserData.EMAIL).
                setPassword(UserData.PASSWORD).
                setConfirmPassword(UserData.PASSWORD).
                setFirstName(firstName).
                setLastName(lastName));
        app.getUserHelper().clickOnRegisterButton();
        Assert.assertTrue( app.getUserHelper().isAlreadyExistsPresent());
    }

    @DataProvider
    public Iterator<Object[]> userNameDataFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

      BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
{
             String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");//

                list.add(new Object[]{ (split[0]), split[1] });// тут мы упоковываем два элемента в массив ..Добовляем этот масив в список лиск

                line = reader.readLine();

                       line = reader.readLine();
            }
        }
        return list.iterator();
    }
}
