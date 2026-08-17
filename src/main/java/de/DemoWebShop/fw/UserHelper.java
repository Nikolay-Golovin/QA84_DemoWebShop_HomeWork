package de.DemoWebShop.fw;

import de.DemoWebShop.core.BaseHelper;
import de.DemoWebShop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {


    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterButton() {
        click(By.name("register-button"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clockOnRegisterLick() {
        click(By.cssSelector("[href='/register']"));
    }
    public String newEmail(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "karl" + i + "@gmail.com";
        return email;
    }
}
