import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Steps;

public class AtTstCreateNewMailAndDelete {
    private Steps steps;
    private final String USERNAME = "testbyeugene@mail.ru";
    private final String PASSWORD = "eugene89";
    private final String ADDRESSEE = "testbyeugene@mail.ru";
    private final String SUBJECT = "Test#1";
    private final String BODY = "The First Test#1";
    private final String DRAFTS = "черновиках";

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to MailRu")
    public void oneCanLoginMailRu() {
        steps.loginMailRu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Create a new mail")
    public void oneCanCreateNewMail() {
        steps.createNewMail(ADDRESSEE, SUBJECT, BODY);
        Assert.assertTrue(steps.isSavedInDrafts(DRAFTS));
    }

    @Test(description = "Check the mail in recycle")
    public void oneCanCheckInDrafts() {
        steps.clickOnDrafts();
        steps.clickOnCheckboxSelectAll();
        steps.clickOnDelete();
        steps.clickOnRecycleFolder();
        Assert.assertTrue(steps.isMessageInRecycle(BODY));
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
