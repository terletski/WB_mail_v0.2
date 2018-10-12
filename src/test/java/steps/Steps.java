package steps;

import driverSingleton.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Steps {
        private WebDriver driver;

        public void initBrowser() {
            driver = DriverSingleton.getDriver();
        }

        public void closeDriver() {
            DriverSingleton.closeDriver();
        }

        public void loginMailRu(String username, String password) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openPage();
            loginPage.login(username, password);
        }

        public boolean isLoggedIn(String username) {
            {
                LoginPage loginPage = new LoginPage(driver);
                String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
                System.out.println("Actual username: " + actualUsername);
                return actualUsername.equals(username);
            }
        }
}







