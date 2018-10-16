package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewMailPage extends AbstractPage{

    // Подготовка элементов страницы.
    @FindBy(xpath = "//*[@id='b-toolbar__left']/div/div/div[2]/div/a/span")
    private WebElement button_new_mail;

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement field_addressee;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement field_subject;

    @FindBy(id = "tinymce")
    private WebElement field_body;

    @FindBy(xpath = "//div[@data-group='save-more']")
    private WebElement button_save;

    @FindBy(xpath = "//span[contains(text(),'Сохранить черновик')]")
    private WebElement button_save_draft;

    @FindBy(xpath = "//a[@href='/messages/drafts']")
    private WebElement mail_in_drafts;

    public CreateNewMailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnNewMail()
    {
        button_new_mail.click();
        System.out.println("Click on <New Mail> explored successfully");
    }


    public void fields(String addressee, String subject, String body)
    {
        field_addressee.sendKeys(addressee);
        field_subject.sendKeys(subject);
        driver.switchTo().frame(driver.findElement(By.xpath(".//tr[@class='mceFirst mceLast']//iframe")));
        driver.findElement(By.id("tinymce")).click();
        field_body.click();
        field_body.clear();
        field_body.sendKeys(body);
        driver.switchTo().defaultContent();
        button_save.click();
        button_save_draft.click();
        System.out.println("Addressee performed");
        System.out.println("Subject performed");
        System.out.println("Body performed");
    }

    public String getDraft()
    {
        return mail_in_drafts.getAttribute("innerText");
    }

    @Override
    public void openPage() {

    }
}
