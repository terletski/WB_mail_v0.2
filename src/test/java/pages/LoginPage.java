package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends AbstractPage
{
	private final String BASE_URL = "https://mail.ru";

	// Подготовка элементов страницы.
	@FindBy(xpath = "//*[@id='mailbox:login']")
	private WebElement inputLogin;

	@FindBy(xpath = "//*[@id='mailbox:password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//*[@value='Войти']")
	private WebElement buttonSubmit;

	@FindBy(id = "PH_user-email")
	private WebElement linkLoggedInUser;

	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	private WebElement linkLogOff;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		System.out.println("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		System.out.println("Login performed");
	}

	public String getLoggedInUserName()
	{
		try {
			Thread.sleep(5000);
			linkLoggedInUser.getAttribute("innerText");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return linkLoggedInUser.getAttribute("innerText");
	}

	public void logout(){
		linkLogOff.click();
		System.out.println("Log off explored explored successfully");
	}
}
