package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SentPage extends AbstractPage {
    private String BASEURL = "https://e.mail.ru/messages/sent/";

    // Подготовка элементов страницы.
    @FindBy(xpath = "//*[@id='b-nav_folders']/div/div[2]/a")
    private WebElement sents_folder;

    @FindBy(xpath = "//*[@id='b-nav_folders']/div/div[2]")
    private List<WebElement> listOfSentMessages;

    public SentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSentsFolder(){
        sents_folder.click();
    }

    public boolean isMessageInSents(String subject, String target, String message){
        for (WebElement draft: listOfSentMessages) {
            if (draft.getText().contains(subject+message+"\n"+target)){
                return true;
            }
        }
        return false;
    }

    public void openPage() {
        driver.navigate().to(BASEURL);
    }
}
