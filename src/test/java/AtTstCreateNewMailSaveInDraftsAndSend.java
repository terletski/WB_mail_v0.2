
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Steps;

public class AtTstCreateNewMailSaveInDraftsAndSend {

    private Steps steps;
    private final String USERNAME = "testbyeugene@mail.ru";
    private final String PASSWORD = "eugene89";
    private final String ADDRESSEE = "testbyeugene@mail.ru";
    private final String SUBJECT = "Test#1";
    private final String BODY = "The First Test#1";
    private final String DRAFTS = "черновиках";

    @BeforeClass(description = "Init browser")
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

    @Test(description = "Create a new mail")
    public void oneCanCreateNewMail() {
        steps.createNewMail(ADDRESSEE, SUBJECT, BODY);
        Assert.assertTrue(steps.isSavedInDrafts(DRAFTS));
    }

    @Test(description = "Check the mail in drafts")
    public void oneCanCheckInDrafts(){
        steps.clickOnDrafts();
        steps.openDraft();
        Assert.assertTrue(steps.isMessageInDraftFolder(ADDRESSEE, BODY, SUBJECT));
    }

    @Test(description = "Check the drafts folder")
    public void oneCanCheckDraftsFolder(){
        steps.clickOnSend();
        steps.clickOnDraftsFolder();
        Assert.assertTrue(steps.isMessageNotInDrafts(ADDRESSEE, BODY, SUBJECT),"Drafts folder is not epmty!");
    }

    @Test(description = "Check the sents folder")
    public void oneCanCheckSentsFolder(){
        steps.clickOnSentsFolder();
        Assert.assertTrue(steps.isMessageInSents(SUBJECT, BODY, ADDRESSEE),"Sents folder is epmty or attribute of letter not contains!");
        steps.clickOnLogOut();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
