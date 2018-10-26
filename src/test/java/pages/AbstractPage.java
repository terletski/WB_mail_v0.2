package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;
	protected WebDriverWait wait;
	private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
	protected Logger logger = LogManager.getRootLogger();

	public abstract void openPage();

	protected void waitForElementVisible(WebElement element) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
	}

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
