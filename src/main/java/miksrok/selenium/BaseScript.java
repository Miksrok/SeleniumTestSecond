package miksrok.selenium;

import miksrok.selenium.util.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

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
    public static EventFiringWebDriver getConfiguredDriver(String browser) {
        WebDriver driver = getDriver(browser);
        driver.manage().window().maximize();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new EventHandler());
        return eventFiringWebDriver;
    }

}
