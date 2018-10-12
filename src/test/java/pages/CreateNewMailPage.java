package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewMailPage extends AbstractPage{

    // Подготовка элементов страницы.
    @FindBy(xpath = "//a[@data-title='Написать письмо (N)']")
    private WebElement button_new_mail;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/div/div[1]/a[1]")
    private WebElement button_view_all;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/nav/ul[2]/li[14]/a")
    private WebElement hrefTesting;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/h1")
    private WebElement message_testing;


    public CreateNewMailPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnMarketplace()
    {
        hrefMarketplace.click();
        System.out.println("Go to <Marketplace> explored successfully");
    }

    public void clickOnViewAll()
    {
        button_view_all.click();
        System.out.println("Go to <Marketplace> explored successfully");
    }

    public void clickOnTesting()
    {
        hrefTesting.click();
        System.out.println("Go to <Marketplace> explored successfully");
    }

    public boolean messageTestingEquals(String search_string) {
        return message_testing.getText().equals(search_string);
    }

    @Override
    public void openPage() {

    }
}
