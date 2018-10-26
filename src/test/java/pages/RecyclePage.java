package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RecyclePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='b-toolbar__right']//div[@data-group='selectAll']//div[@data-model='13']//div[@class='b-checkbox__box']")
    private WebElement checkbox_select_all;

    @FindBy(xpath = "///div[@data-cache-key='500002_undefined_false']//div[@data-shortcut-title='Del']")
    private WebElement button_delete;

    @FindBy(xpath = "///div[@class='b-nav b-nav_folders b-nav_icons b-nav_settings-on-hover']//a[@href='/messages/trash/']")
    private WebElement recycle_folder;

    public RecyclePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCheckboxSelectAll()
    {
        checkbox_select_all.click();
        logger.info("Click on <Select all> explored successfully");
    }

    public void clickOnDelete()
    {
        button_delete.click();
        logger.info("Click on <Delete> explored successfully");
    }

    public void clickOnRecycleFolder(){
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='b-nav b-nav_folders b-nav_icons b-nav_settings-on-hover']//a[@href='/messages/trash/']")));
        logger.info("Click on <Recycle folder> explored successfully");
    }

    public boolean isMessageInRecycle(String subject){
        int index = 0;
        List<WebElement> recycles = driver.findElements(By.xpath("//div[@class='b-datalist b-datalist_letters b-datalist_letters_from']//div[@class='b-datalist__body']"));
        for (WebElement recycle: recycles) {
            System.out.println("Letter in recycle: " + recycle.getAttribute("innerText"));
            if (recycle.getAttribute("innerText").contains(subject)) {
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
