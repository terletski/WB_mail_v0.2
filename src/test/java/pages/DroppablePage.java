package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DroppablePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='b-letters']/div[1]/div[2]/div/div[2]/div[1]")
    private WebElement draggable_locator;

    @FindBy(xpath = "//a[@href='/messages/spam/']")
    private WebElement drappable_locator;

    public DroppablePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public DroppablePage dragNDropSpam() {
        new Actions(driver).dragAndDrop(draggable_locator, drappable_locator).build().perform();
        logger.info("Successfully dragged in spam!");
        return this;
    }

    public void clickOnSpam() {
        drappable_locator.click();
        logger.info("Click on <Spam> explored successfully");
    }

    public boolean isMessageInSpam(String subject, String message){
        int index = 0;
        List<WebElement> spams = driver.findElements(By.xpath("//*[@id='b-letters']//div[@class='b-datalist__body']"));
        for (WebElement spam: spams) {
            System.out.println("Letter: " + spam.getAttribute("innerText"));
            if (spam.getAttribute("innerText").contains(subject + message)) {
                return true;
            }
            index++;
        }
        return false;
    }


    @Override
    public void openPage() {

    }
}
