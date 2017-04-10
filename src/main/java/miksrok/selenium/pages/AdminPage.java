package miksrok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public void clickCategory() throws InterruptedException {
        Actions action = new Actions(driver) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminCatalog")));
        WebElement element = driver.findElement(By.id("subtab-AdminCatalog"));
        WebElement elem = driver.findElement(By.id("subtab-AdminCategories"));
        action.moveToElement(element)
                .moveToElement(elem)
                .click()
                .build()
                .perform();

    }

    public void createNewCategory() {
    }

    public void filterByName() {
    }
}
