package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='b-letters']/div[1]/div[5]/div/div[2]")
    private WebElement spam_letter;

    @FindBy(xpath = "//*[@id='b-toolbar__right']/div[5]/div[2]/div/div[1]/div[2]/div/div[2]/span")
    private WebElement button_save;

    @FindBy(xpath = "//a[@href='/messages/drafts']")
    private WebElement mail_in_drafts;

    public SpamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SpamPage clickOnLetterInSpam() {
        new Actions(driver).click(spam_letter).build().perform();
        logger.info("Successfully dragged in spam!");
        return this;
    }

    public void fields(String body)
    {
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent= arguments[1];", body);
        driver.switchTo().defaultContent();
        button_save.click();
        logger.info("Body performed");
    }

    public String getDraft()
    {
        return mail_in_drafts.getAttribute("innerText");
    }


        @Override
        public void openPage () {
    }
}
