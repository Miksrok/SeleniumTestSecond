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

    private final static String CHROME_PATH = "src\\main\\resources\\chromedriver.exe";
    private final static String FIREFOX_PATH = "src\\main\\resources\\geckodriver.exe";

    private static WebDriver getDriver(String browser) {

        switch (browser){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                return new ChromeDriver();
            }
            default:{
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
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
