package miksrok.selenium.pages;

import miksrok.selenium.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public class LoginPage{

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openLoginPage(){
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
    }

    public AdminPage login(String login, String password){
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
        return new AdminPage(driver);
    }


}
