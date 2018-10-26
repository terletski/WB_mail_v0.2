package steps;

import driverSingleton.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

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

        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
        System.out.println("Actual username: " + actualUsername);
        return actualUsername.equals(username);
    }

    public void createNewMail(String addressee, String subject, String body) {
        CreateNewMailPage createNewMailPage = new CreateNewMailPage(driver);
        createNewMailPage.clickOnNewMail();
        createNewMailPage.fields(addressee, subject, body);
    }

    public boolean isSavedInDrafts(String draft) {
        WebElement mail_in_drafts = (new WebDriverWait(driver, 5000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/messages/drafts']")));

        CreateNewMailPage createNewMailPage = new CreateNewMailPage(driver);
        String actualDraft = createNewMailPage.getDraft().trim().toLowerCase();
        System.out.println("Saved in: " + actualDraft);
        return actualDraft.equals(draft);
    }

    public void clickOnDrafts() {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickOnDrafts();
    }

    public boolean isMessageInDraftFolder(String target, String message, String subject) {
        DraftsPage draftsPage = new DraftsPage(driver);
        return draftsPage.isMessageInDrafts(target, message, subject);
    }

    public void openDraft(){
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickOnDraft();
    }

    public void clickOnSend(){
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickOnSend();
    }

    public void clickOnDraftsFolder(){
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickOnDraftsFolder();
    }

    public boolean isMessageNotInDrafts(String subject, String target, String message){
        DraftsPage draftsPage = new DraftsPage(driver);
        return draftsPage.isMessageNotInDrafts(subject, target, message);
    }

    public void clickOnSentsFolder(){
        SentPage sentPage = new SentPage(driver);
        sentPage.clickOnSentsFolder();
    }

    public boolean isMessageInSents(String target, String message, String subject){
        SentPage sentPage = new SentPage(driver);
        return sentPage.isMessageInSents(target, message, subject);
    }

    public void clickOnLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
    }

    public void clickOnCheckboxSelectAll(){
        RecyclePage recyclePage = new RecyclePage(driver);
        recyclePage.clickOnCheckboxSelectAll();
    }

    public void clickOnDelete(){
        RecyclePage recyclePage = new RecyclePage(driver);
        recyclePage.clickOnDelete();
    }

    public void clickOnRecycleFolder(){
        RecyclePage recyclePage = new RecyclePage(driver);
        recyclePage.clickOnRecycleFolder();
    }

    public boolean isMessageInRecycle(String subject){
        RecyclePage recyclePage = new RecyclePage(driver);
        return recyclePage.isMessageInRecycle(subject);
    }

    public void dragNDropSpam(){
        DroppablePage droppablePage = new DroppablePage(driver);
        droppablePage.dragNDropSpam();
    }

    public void clickOnSpamFolder(){
        DroppablePage droppablePage = new DroppablePage(driver);
        droppablePage.clickOnSpam();
    }

    public boolean isMessageInSpamFolder(String subject, String message) {
        DroppablePage droppablePage = new DroppablePage(driver);
        return droppablePage.isMessageInSpam(subject, message);
    }

    public void clickOnLetterInSpam(){
        SpamPage spamPage = new SpamPage(driver);
        spamPage.clickOnLetterInSpam();
    }

    public void changeTheMessage(String body){
        SpamPage spamPage = new SpamPage(driver);
        spamPage.fields(body);
    }

    public boolean hasToGetDraft(String body){
        SpamPage spamPage = new SpamPage(driver);
        String actualDraft = spamPage.getDraft().trim().toLowerCase();
        System.out.println("Saved in: " + actualDraft);
        return actualDraft.equals(body);
    }
}






