package de.DemoWebShop.core;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseHelper {


    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        click(locator);
       driver.findElement(locator).clear();
       driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//*[.='Log out']"));
    }

    public boolean isAlreadyExistsPresent() {
        return isElementPresent(By.xpath("//*[.='The specified email already exists']"));
    }
    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("Screenshot/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);


        }
        return screen.getAbsolutePath();

    }
}

