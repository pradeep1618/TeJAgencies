package process;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import customActions.Actionss;
import element.CreatAgent;
import element.ServiceAgent;
import utils.Browser;
import utils.Excel;

public class AServiceAgents extends Browser
{
	@Test
	public void create(boolean delete, boolean pdf, boolean Xl) throws Throwable 
	{
		String path = System.getProperty("user.dir");
		String writeresults= path+"/XLData/Agent_Data.xlsx";
		Excel excel = new Excel(path+"/XLData/Agent_Data.xlsx");
		int row = excel.rowCount("ServiceAgents");
		Actionss func = new Actionss();


		WebDriverWait wait = new WebDriverWait(drive, 20);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.master)));
		drive.findElement(ServiceAgent.master).click();
		drive.findElement(ServiceAgent.processlnk).click();
		Thread.sleep(1000);

		for(int r=1;r<=row;r++)
		{
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.AddSerAge)));
			drive.findElement(ServiceAgent.AddSerAge).click();
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.sAname)));
			drive.findElement(ServiceAgent.sAname).clear();
			drive.findElement(ServiceAgent.sAname).sendKeys(excel.getcelldata("ServiceAgents", r, 0));
			
			drive.findElement(ServiceAgent.sAMailing).clear();
			drive.findElement(ServiceAgent.sAMailing).sendKeys(excel.getcelldata("ServiceAgents", r, 1));
			
			drive.findElement(ServiceAgent.sAMailCity).clear();
			drive.findElement(ServiceAgent.sAMailCity).sendKeys(excel.getcelldata("ServiceAgents", r, 2));
			Select Mstate = new Select(drive.findElement(ServiceAgent.sAMailState));
			Mstate.selectByValue(excel.getcelldata("ServiceAgents", r, 3));
			
			drive.findElement(ServiceAgent.sAMailZip).clear();
			drive.findElement(ServiceAgent.sAMailZip).sendKeys(excel.getcelldata("ServiceAgents", r, 4));
		
			drive.findElement(ServiceAgent.sAStreet).clear();
			drive.findElement(ServiceAgent.sAStreet).sendKeys(excel.getcelldata("ServiceAgents", r, 5));
			
			drive.findElement(ServiceAgent.sAStreetCity).clear();
			drive.findElement(ServiceAgent.sAStreetCity).sendKeys(excel.getcelldata("ServiceAgents", r, 6));
			
			
			Select Sstate = new Select(drive.findElement(ServiceAgent.sAStreetState));
			Sstate.selectByValue(excel.getcelldata("ServiceAgents", r, 7));
			
			drive.findElement(ServiceAgent.sAStreetZip).clear();
			drive.findElement(ServiceAgent.sAStreetZip).sendKeys(excel.getcelldata("ServiceAgents", r, 8));
			drive.findElement(ServiceAgent.sAEmail).clear();
			drive.findElement(ServiceAgent.sAEmail).sendKeys(excel.getcelldata("ServiceAgents", r, 9));
			drive.findElement(ServiceAgent.sAPhone).clear();
			drive.findElement(ServiceAgent.sAPhone).sendKeys(excel.getcelldata("ServiceAgents", r, 10));
			drive.findElement(ServiceAgent.sAMobile).clear();
			drive.findElement(ServiceAgent.sAMobile).sendKeys(excel.getcelldata("ServiceAgents", r, 11));
		
			drive.findElement(ServiceAgent.sASubmit).click();
			Thread.sleep(1000);
			
			if(!drive.findElement(ServiceAgent.sAOkay).isDisplayed())
			{
				drive.findElement(ServiceAgent.sAClose).click();
				
			}
			else
			{
				drive.findElement(ServiceAgent.sAOkay).click();
				
			}
			excel.setCelldata("ServiceAgents", r, 12, "Pass", writeresults);
			excel.greencolour("ServiceAgents", r, 12, writeresults);
			Thread.sleep(500);
			
			if(delete==true) 
			{
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.AddSerAge)));
				drive.findElement(By.xpath("//table//tr[contains(.,'"+excel.getcelldata("ServiceAgents", r, 0)+"')]//child::a[@title='Delete Servicing Agent']")).click();	
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.sADelOK)));
				drive.findElement(ServiceAgent.sADelOK).click();
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ServiceAgent.sADelConf)));
				drive.findElement(ServiceAgent.sADelConf).click();
			}


		}
		if(pdf==true)
		{
			drive.findElement(ServiceAgent.sAPdf).click();
			
		}
		if(Xl==true)
		{
			drive.findElement(ServiceAgent.sAExcel).click();
			
		}

	}
}
