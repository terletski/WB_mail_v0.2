package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DraftsPage extends AbstractPage {

    private String BASEURL = "https://e.mail.ru/messages/drafts/";
    private int index;

    // Подготовка элементов страницы.
    @FindBy(xpath = "//*[@id='b-nav_folders']/div/div[3]/a/span")
    private WebElement button_drafts;

    @FindBy(xpath = "//*[@id='b-letters']/div[1]/div[5]/div/div[2]/div")
    private List<WebElement> listOfDrafts;

    @FindBy(xpath = "//div[@data-name='send']")
    private WebElement send_draft;

    @FindBy(xpath = "//a[@data-shortcut='g,s']")
    private WebElement sentsFolder;

    @FindBy(xpath = "//a[@data-mnemo='drafts']")
    private WebElement button_drafts_folder;

    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnDrafts() {
        try {
            Thread.sleep(5000);
            button_drafts.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("Click on <Drafts> explored successfully");
    }

    public boolean isMessageInDrafts(String target, String message, String subject){
        int index = 0;
        List<WebElement> drafts = driver.findElements(By.xpath("//div[@class='b-datalist__item js-datalist-item b-datalist__item_last']//div[@class='b-datalist__item__panel']"));
        for (WebElement draft: drafts) {
            Assert.assertEquals(draft.getAttribute("innerText"), subject + message  + target,"111111111");
            System.out.println("Letter: " + draft.getAttribute("innerText"));
            if (draft.getAttribute("innerText").contains(subject + message  + target)) {
                return true;
            }
            index++;
        }
            return false;
    }

    public boolean isMessageNotInDrafts(String subject, String target, String message){

        for (WebElement draft: listOfDrafts) {
            if (draft.getText().contains(subject+message+"\n"+target)){
                try{
                    wait.until(ExpectedConditions.not(visibilityOf(draft)));
                }
                catch (Exception e){
                    return false;
                }
                return true;
            }
        }
        return true;
    }


    public void clickOnDraft(){

        listOfDrafts.get(index).click();
    }

    public void clickOnSend(){
        send_draft.click();
        System.out.println("Click on <Send> explored successfully");
    }

    public void clickOnDraftsFolder() {
        button_drafts_folder.click();
        System.out.println("Click on <Drafts Folder> explored successfully");
    }

    public void openPage() {
        driver.navigate().to(BASEURL);
    }
}


