
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import steps.Steps;

public class MailAutomationTest {

    private Steps steps;
    private final String USERNAME = "testbyeugene@mail.ru";
    private final String PASSWORD = "eugene89";
    private final String ADDRESSEE = "testbyeugene@mail.ru";
    private final String SUBJECT = "Test#1";
    private final String BODY = "The First Test#1";
    private final String DRAFTS = "черновиках";

    @Test(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Login to MailRu", priority = 1)
    public void oneCanLoginMailRu() {
        steps.loginMailRu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Create a new mail", priority = 2)
    public void oneCanCreateNewMail() {
        steps.createNewMail(ADDRESSEE, SUBJECT, BODY);
        Assert.assertTrue(steps.isSavedInDrafts(DRAFTS));
    }

    @Test(description = "Check the mail in drafts", priority = 3)
    public void oneCanCheckInDrafts(){
        steps.clickOnDrafts();
        steps.openDraft();
        Assert.assertTrue(steps.isMessageInDraftFolder(ADDRESSEE, BODY, SUBJECT));
    }

    @Test(description = "Check the drafts folder", priority = 4)
    public void oneCanCheckDraftsFolder(){
        steps.clickOnSend();
        steps.clickOnDraftsFolder();
        Assert.assertTrue(steps.isMessageNotInDrafts(ADDRESSEE, BODY, SUBJECT),"Drafts folder is not epmty!");
    }

    @Test(description = "Check the sents folder", priority = 5)
    public void oneCanCheckSentsFolder(){
        steps.clickOnSentsFolder();
        Assert.assertTrue(steps.isMessageInSentFolder(ADDRESSEE, BODY, SUBJECT),"Sents folder is epmty!");
        steps.clickOnLogOut();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
