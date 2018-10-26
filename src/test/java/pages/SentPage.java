package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SentPage extends AbstractPage {

    private String BASEURL = "https://e.mail.ru/messages/sent/";

    @FindBy(xpath = "//div[@class='b-nav b-nav_folders b-nav_icons b-nav_settings-on-hover']//a[@href='/messages/sent/']")
    private WebElement sents_folder;

    @FindBy(xpath = "//div[@data-cache-key='500000_undefined_false']//div[@class='b-datalist b-datalist_letters b-datalist_letters_to']//div[@class='b-datalist__body']")
    private List<WebElement> listOfSentMessages;

    public SentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSentsFolder(){
        sents_folder.click();
    }

    public boolean isMessageInSents(String target, String message, String subject){
        int index = 0;
        List<WebElement> sents = driver.findElements(By.xpath("//div[@data-cache-key='500000_undefined_false']//div[@class='b-datalist b-datalist_letters b-datalist_letters_to']//div[@class='b-datalist__body']"));
        for (WebElement sent: sents) {
            System.out.println("Letter in sents: " + sent.getAttribute("innerText"));
            if (sent.getAttribute("innerText").contains(subject + message + target)) {
                return true;
            }
            index++;
        }
        return false;
    }

    public void openPage() {
        driver.navigate().to(BASEURL);
    }
}
