package driverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverSingleton {

    private static WebDriver driver;
    private static WebDriver instance;
    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_CHROMEDRIVER_EXE_PATH = ".\\chromedriver\\chromedriver.exe";

    private DriverSingleton(){};

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = getDriver();
    }

    public static WebDriver getDriver(){
        if (null == driver){
//            System.setProperty(WEBDRIVER_CHROMEDRIVER, CHROMEDRIVER_CHROMEDRIVER_EXE_PATH);
//            driver = new ChromeDriver();
            try {
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            System.out.println("Browser was successfully started");
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
        System.out.println("Browse was successfully quited.");
    }
}
