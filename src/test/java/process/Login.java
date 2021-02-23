package process;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import customActions.Actionss;
import element.HomePage;
import utils.Browser;
import utils.Excel;

public class Login extends Browser
{
	Actionss driv = new Actionss();
	/**
	 * Sign in to the application
	 * @param user
	 * @param passW
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test
	public void signIn() throws Throwable 
	{
		String details = System.getProperty("user.dir");
		String writeresults= details+"/XLData/Agent_Data.xlsx";
		Excel excel = new Excel(details+"/XLData/Agent_Data.xlsx");
		int row = excel.rowCount("Users");
		String userName=excel.getcelldata("Users", 1, 0);
		String passWord = excel.getcelldata("Users", 1, 1);
		WebDriverWait wait = new WebDriverWait(drive, 10);
		wait.until(ExpectedConditions.or(
		ExpectedConditions.visibilityOfElementLocated(HomePage.userName)));
		drive.findElement(By.xpath("//input[@id='UserID']")).clear();
		drive.findElement(By.xpath("//input[@id='UserID']")).sendKeys(userName);
		drive.findElement(HomePage.passWord).clear();
		drive.findElement(HomePage.passWord).sendKeys(passWord);
		drive.findElement(HomePage.logButton).click();
		for(int r=1;r<=row;r++)
		{	
		excel.setCelldata("Users", r, 2, "Pass", writeresults);
		excel.greencolour("Users", r, 2, writeresults);
		}
	}
	

}
