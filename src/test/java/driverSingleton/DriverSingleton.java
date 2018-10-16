package driverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_CHROMEDRIVER_EXE_PATH = ".\\chromedriver\\chromedriver.exe";

    private DriverSingleton(){};


    public static WebDriver getDriver(){
        if (null == driver){
            System.setProperty(WEBDRIVER_CHROMEDRIVER, CHROMEDRIVER_CHROMEDRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
