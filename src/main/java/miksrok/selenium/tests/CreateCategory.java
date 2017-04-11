package miksrok.selenium.tests;

import miksrok.selenium.BaseScript;
import miksrok.selenium.pages.AdminPage;
import miksrok.selenium.pages.LoginPage;

import java.util.Random;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public class CreateCategory extends BaseScript {

    private static String defaultBrowser = "firefox";
    private static String chromeBrowser = "chrome";
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "myNewTestCategory"+new Random().nextInt(100);

    public static void main(String[] args) throws InterruptedException {

        LoginPage loginPage = new LoginPage(getConfiguredDriver(chromeBrowser));
        loginPage.openLoginPage();
        AdminPage adminPage = loginPage.login(login, password);
        adminPage.clickCategory();
        if(adminPage.createNewCategory(categoryName)) {
            adminPage.filterByName(categoryName);
        }else{
            System.out.println("category doesn't create");
        }
        adminPage.closeBrowser();





    }

}
