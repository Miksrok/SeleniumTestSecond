package miksrok.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public abstract class BaseScript {


    public static WebDriver getDriver(String browser) {

        switch (browser){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                return new ChromeDriver();
            }
            default:{
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                return new FirefoxDriver();
            }
        }


    }

}
