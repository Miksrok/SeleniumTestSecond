package miksrok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogLink = By.id("subtab-AdminCatalog");
    private By categoryLink = By.id("subtab-AdminCategories");
    private By newCategory = By.cssSelector("#page-header-desc-category-new_category");
    private By categoryName = By.cssSelector("#name_1");
    private By submitCategoryButton = By.cssSelector("#category_form_submit_btn");
    private By successMessage = By.cssSelector(".alert-success");
    private By filterArea = By.name("categoryFilter_name");
    private By submitFilterButton = By.cssSelector("#submitFilterButtoncategory");
    private By text = By.cssSelector("#table-category tbody");


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public void clickCategory() throws InterruptedException {
        Actions action = new Actions(driver) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.catalogLink));
        WebElement catalogLink = driver.findElement(this.catalogLink);
        WebElement categoryLink = driver.findElement(this.categoryLink);
        action.moveToElement(catalogLink)
                .moveToElement(categoryLink)
                .click()
                .build()
                .perform();
    }

    public boolean createNewCategory(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.newCategory));
        WebElement newCategory = driver.findElement(this.newCategory);
        newCategory.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.categoryName));
        WebElement categoryName = driver.findElement(this.categoryName);
        categoryName.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.submitCategoryButton));
        WebElement submitCategoryButton = driver.findElement(this.submitCategoryButton);
        submitCategoryButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.successMessage));
        String successMessage = driver.findElement(this.successMessage).getText();
        return successMessage.contains("Создано");
    }

    public void filterByName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.filterArea));
        WebElement filterArea = driver.findElement(this.filterArea);
        filterArea.sendKeys(name);
        WebElement submitFilterButton = driver.findElement(this.submitFilterButton);
        submitFilterButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(this.text, name));
    }

    public void closeBrowser(){
        driver.quit();
    }
}
