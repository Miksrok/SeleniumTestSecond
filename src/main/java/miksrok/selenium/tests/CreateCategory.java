package miksrok.selenium.tests;

import miksrok.selenium.BaseScript;
import miksrok.selenium.pages.AdminPage;
import miksrok.selenium.pages.LoginPage;

/**
 * Created by Залізний Мозок on 09.04.2017.
 */
public class CreateCategory extends BaseScript {

    private static String defaultBrowser = "firefox";
    private static String chromeBrowser = "chrome";
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver(defaultBrowser));
        loginPage.openLoginPage();
        AdminPage adminPage = loginPage.login(login, password);
        adminPage.clickCategory();
       /* adminPage.createNewCategory();
        adminPage.filterByName();*/




    }

}
