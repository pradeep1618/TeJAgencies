package customActions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Browser;

public class Actionss
{
	WebDriver driver;
	public void ActionDriver()
	{
		driver=Browser.drive;
	}


	/**
	 * Used to click on the element
	 * @param locator
	 */
	public void click (By locator)
	{
		driver.findElement(locator).click();
	}

	/**
	 * Used to type text in the text box after clearing
	 * @param locator
	 * @param text
	 * @throws InterruptedException 
	 */
	public void sendText(By locator, String text) throws Throwable
	{

		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}


	/**
	 * Used to move mouse to an element
	 * @param locator
	 */
	public void mouseover(By locator)
	{
		Actions a = new Actions(driver);
		WebElement mouse =  driver.findElement(locator);
		a.moveToElement(mouse).build().perform();
	}

	/**
	 * uses to select element by value
	 * @param element -- element
	 * @param value --value which we want to select
	 */
	public void selectbyValue(By element, String value)
	{
		WebElement dropdown = driver.findElement(element);
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	/**
	 * @param element
	 * @param visualText
	 */
	public void selectByVisualText(By element, String visualText)
	{
		WebElement dropdown = driver.findElement(element);
		Select select = new Select(dropdown);
		select.selectByVisibleText(visualText);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectByIndex(By element, int index)
	{
		WebElement dropdown = driver.findElement(element);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	/**
	 * @param element
	 * @param index
	 */
	public void deSelectByIndex(By element, int index)
	{
		WebElement dropdown = driver.findElement(element);
		Select select = new Select(dropdown);
		select.deselectByIndex(index);
	}
	/**
	 * 
	 * @param locator
	 * @param seconds
	 */
	public void waitForElementClick(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * 
	 * @param locator
	 * @param seconds
	 */
	public void waitUntilVisibilityofElement(By locator, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(locator)));	

	}

}
