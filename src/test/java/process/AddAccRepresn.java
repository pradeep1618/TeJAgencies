package process;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import element.Account_Rep;
import element.CreatAgent;
import utils.Browser;
import utils.Excel;

public class AddAccRepresn extends Browser
{
	@Test
	public void accRepresentative(boolean delete) throws Throwable{
		String path = System.getProperty("user.dir");
		String writeresults= path+"/XLData/Agent_Data.xlsx";

		Excel exce = new Excel(path+"/XLData/Agent_Data.xlsx");
		int row = exce.rowCount("Account Producer");


		WebDriverWait wait = new WebDriverWait(drive, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.masterData)));
		drive.findElement(CreatAgent.masterData).click();
		drive.findElement(Account_Rep.link).click();

		for(int r=1; r<=row;r++)
		{
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repAddBF)));
			Thread.sleep(2500);
			
			drive.findElement(Account_Rep.repAddBF).click();

			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repNameF)));
			String repName=exce.getcelldata("Account Producer", r, 0);
			drive.findElement(Account_Rep.repNameF).clear();
			drive.findElement(Account_Rep.repNameF).sendKeys(repName);
			drive.findElement(Account_Rep.repPhoneF).clear();
			drive.findElement(Account_Rep.repPhoneF).sendKeys(exce.getcelldata("Account Producer", r, 1));
			drive.findElement(Account_Rep.repEmailF).clear();
			drive.findElement(Account_Rep.repEmailF).sendKeys(exce.getcelldata("Account Producer", r, 2));
			drive.findElement(Account_Rep.repAddressF).clear();
			drive.findElement(Account_Rep.repAddressF).sendKeys(exce.getcelldata("Account Producer", r, 3));
			drive.findElement(Account_Rep.repMobileF).clear();
			drive.findElement(Account_Rep.repMobileF).sendKeys(exce.getcelldata("Account Producer", r, 4));
			drive.findElement(Account_Rep.repCityF).clear();
			drive.findElement(Account_Rep.repCityF).sendKeys(exce.getcelldata("Account Producer", r, 5));
			drive.findElement(Account_Rep.repZIPF).clear();
			drive.findElement(Account_Rep.repZIPF).sendKeys(exce.getcelldata("Account Producer", r, 7));
			Select state = new Select(drive.findElement(Account_Rep.repStatF));
			state.selectByVisibleText(exce.getcelldata("Account Producer", r, 6));
			
			drive.findElement(Account_Rep.repSubmit).click();
			
			Thread.sleep(1000);
			if(drive.findElement(By.xpath("//div[@class='modal-body']//following::p[@id='successModalMessage']")).getText().contains("submitted successfully"))
			{
				
				drive.findElement(Account_Rep.repAcc).click();


			}

			else
			{
				
				if(drive.findElement(Account_Rep.repError).getText().contains("already exis"))
				{
					wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repError)));
					drive.findElement(Account_Rep.repError).click();
					Thread.sleep(1500);

					drive.findElement(Account_Rep.repClose).click();
				}

			}



			exce.setCelldata("Account Producer", r, 8, "Pass", writeresults);

			exce.greencolour("Account Producer", r, 8, writeresults);

			
			//      Delete Account Representative 
			if(delete==true)
			{
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repAddBF)));
				drive.findElement(By.xpath("//table//tr[contains(.,'"+repName+"')]//child::a[@title='Delete Account Producer']")).click();
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repDelOK)));
				drive.findElement(Account_Rep.repDelOK).click();
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Account_Rep.repAcc)));
				drive.findElement(Account_Rep.repAcc).click();

			}
		}



	}

}
