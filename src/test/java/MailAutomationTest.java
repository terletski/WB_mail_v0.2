
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class MailAutomationTest {

    private Steps steps;
    private final String USERNAME = "testbyeugene@mail.ru";
    private final String PASSWORD = "ByEugene89";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to MailRu")
    public void oneCanLoginMailRu() {
        steps.loginMailRu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
