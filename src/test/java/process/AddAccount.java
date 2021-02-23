package process;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import element.AddAcc;
import utils.Browser;

public class AddAccount extends Browser  
{

	public void addAccounts(String AccountID, String AccountType, String AccountName, 
			String accountprodu, String serviceAge, String StreetNum,String mStreet,
			String mCity,String mState, String mZip, String accountProg1,String bicDays,String accountProg2,
			String sDate,String eDate, String days,String stat, String actDate  ) throws Throwable

	{

		WebDriverWait wait1 = new WebDriverWait(drive, 10);
		wait1.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(AddAcc.accLink)));
		drive.findElement(AddAcc.accLink).click();
		drive.findElement(AddAcc.addAc).click();
		WebDriverWait wait2 = new WebDriverWait(drive, 10);
		wait2.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(AddAcc.setUpC)));
		drive.findElement(AddAcc.accID).clear();
		drive.findElement(AddAcc.accID).sendKeys(AccountID);
		Select accountTy=new Select(drive.findElement(AddAcc.accTyp));
		accountTy.selectByValue(AccountType);
		drive.findElement(AddAcc.accName).clear();
		drive.findElement(AddAcc.accName).sendKeys(AccountName);

		//		Adding Account Producer
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		drive.findElement(AddAcc.Accproducer).sendKeys(accountprodu);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		//		Adding Service Agent
		drive.findElement(AddAcc.SerAgen).sendKeys(serviceAge);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		//		Account Mailing Address

		drive.findElement(AddAcc.mailNum).clear();
		drive.findElement(AddAcc.mailNum).sendKeys(StreetNum);
		drive.findElement(AddAcc.mailStreet).clear();
		drive.findElement(AddAcc.mailStreet).sendKeys(mStreet);
		drive.findElement(AddAcc.mailCity).clear();
		drive.findElement(AddAcc.mailCity).sendKeys(mCity);
		drive.findElement(AddAcc.mailState).click();
		drive.findElement(AddAcc.mailStateTex).clear();
		drive.findElement(AddAcc.mailStateTex).sendKeys(mState);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		drive.findElement(AddAcc.mailZip).clear();
		drive.findElement(AddAcc.mailZip).sendKeys(mZip);
		//		Account Programs

		drive.findElement(By.xpath("//div[@class='custom-control custom-checkbox']//label[@for='"+accountProg1+"']")).click();
		//		Bic Days

		drive.findElement(By.xpath("//input[@id='"+accountProg1+"brdays']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"brdays']")).sendKeys(bicDays);
		drive.findElement(By.xpath("//div[@class='custom-control custom-checkbox']//label[@for='"+accountProg2+"']")).click();
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"brdays']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"brdays']")).sendKeys(bicDays);
		//		Selecting start Date
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"StartDate']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"StartDate']")).sendKeys(sDate);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"StartDate']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"StartDate']")).sendKeys(sDate);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		//		Selecting End Date
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"EndDate']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"EndDate']")).sendKeys(eDate);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"EndDate']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"EndDate']")).sendKeys(eDate);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		//		Program No Of Days
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"NoOfDays']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg1+"NoOfDays']")).sendKeys(days);
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"NoOfDays']")).clear();
		drive.findElement(By.xpath("//input[@id='"+accountProg2+"NoOfDays']")).sendKeys(days);
		drive.findElement(AddAcc.copyMail).click();
		//		Completing setup
		drive.findElement(AddAcc.compSet).click();
		//		Selecting Account Status

		Select statSel=new Select(drive.findElement(AddAcc.accStatus));
		statSel.selectByVisibleText(stat);
		//		Selecting Activation date

		drive.findElement(AddAcc.activeDate).sendKeys(actDate);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);

		//		Submitting Data

		drive.findElement(AddAcc.subButt).click();
		Thread.sleep(1000);
		if(drive.findElement(AddAcc.popUpSuccess).isDisplayed()) {
			drive.findElement(AddAcc.popUpSuccess).click();
		}
	}

	public void accountCollateral(String accountNumber) throws Throwable
	{

		WebDriverWait wait1 = new WebDriverWait(drive, 10);
		wait1.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(AddAcc.accLink)));

		drive.findElement(AddAcc.accLink).click();
		drive.findElement(AddAcc.accountinfo).click();
		Thread.sleep(1000);
		List<WebElement> infoIcon= drive.findElements(By.xpath("//*[@id='tblSearchData']//tr[contains(.,'"+accountNumber+"')]//span"));
		int present = infoIcon.size();
		if(present!=0) 
		{
			drive.findElement(By.xpath("//*[@id='tblSearchData']//tr[contains(.,'"+accountNumber+"')]//span")).click();
		}
		drive.findElement(AddAcc.accLink).click();
		drive.findElement(AddAcc.accountinfo).click();


	}

	public void deleteAccount(String accountNumber )throws Throwable
	{
		WebDriverWait wait1 = new WebDriverWait(drive, 10);
		wait1.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(AddAcc.accLink)));

		drive.findElement(AddAcc.accLink).click();
		drive.findElement(AddAcc.accountinfo).click();
		drive.findElement(By.xpath("//*[@id='tblSearchData']/tbody/tr[contains(.,'"+accountNumber+"')]/td[3]/a/i")).click();
		//	drive.findElement(AddAcc.delIcon).click();
		Thread.sleep(500);
		String popUpMessage=drive.findElement(By.xpath("//div[@id='confirmMessage']")).getText();
		System.out.println(popUpMessage);
		//	assertEquals(popUpMessage, "Do you really want to delete this record?");
		drive.findElement(AddAcc.popOk).click();
		Thread.sleep(500);
		drive.findElement(AddAcc.popUpOk).click();
	}
}


