package process;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import element.CreatAgent;
import utils.Browser;
import utils.Excel;

public class AddAgent extends Browser {

	@Test
	public void create(boolean delete) throws Throwable 
	{
		String path = System.getProperty("user.dir");
		String writeresults= path+"/XLData/Agent_Data.xlsx";
		Excel excel = new Excel(path+"/XLData/Agent_Data.xlsx");
		int row = excel.rowCount("Agents");


		WebDriverWait wait = new WebDriverWait(drive, 20);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.masterData)));
		drive.findElement(CreatAgent.masterData).click();
		drive.findElement(CreatAgent.agent).click();


		for(int r =1;r<=row;r++) 
			{
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.addAgent)));
				Thread.sleep(1500);
				drive.findElement(CreatAgent.addAgent).click();
				wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.agePhone)));
				drive.findElement(CreatAgent.agePhone).clear();
				drive.findElement(CreatAgent.agePhone).sendKeys(excel.getcelldata("Agents", r, 5));
				drive.findElement(CreatAgent.ageName).clear();
				String ageName = excel.getcelldata("Agents", r, 0);
				drive.findElement(CreatAgent.ageName).sendKeys(ageName);
				drive.findElement(CreatAgent.ageConName).clear();
				drive.findElement(CreatAgent.ageConName).sendKeys(ageName);
				drive.findElement(CreatAgent.ageAddress).clear();
				drive.findElement(CreatAgent.ageAddress).sendKeys(excel.getcelldata("Agents", r, 1));
				drive.findElement(CreatAgent.ageAddress1).clear();
				drive.findElement(CreatAgent.ageAddress1).sendKeys(excel.getcelldata("Agents", r, 1));
				Select state = new Select(drive.findElement(CreatAgent.ageState));
				state.selectByValue(excel.getcelldata("Agents", r, 2));
				drive.findElement(CreatAgent.ageCity).clear();
				drive.findElement(CreatAgent.ageCity).sendKeys(excel.getcelldata("Agents", r, 3));
				drive.findElement(CreatAgent.ageZIP).clear();
				drive.findElement(CreatAgent.ageZIP).sendKeys(excel.getcelldata("Agents", r, 4));
				drive.findElement(CreatAgent.ageEmail).clear();
				drive.findElement(CreatAgent.ageEmail).sendKeys(excel.getcelldata("Agents", r, 6));
				drive.findElement(CreatAgent.ageFax).clear();
				drive.findElement(CreatAgent.ageFax).sendKeys(excel.getcelldata("Agents", r, 7));
				drive.findElement(CreatAgent.fromSubBtt).click();
	
				String browInd = drive.getCurrentUrl();
				boolean urlsss = browInd.contains("Agent/Create");
				Thread.sleep(1500);
				if(urlsss)
				{
					drive.navigate().to("http://scshyd-174:8181/Agent/Index");	
	
				}
				else
				{
					try 
					{		
						if(!drive.findElement(CreatAgent.ageOk).isDisplayed()) 
						{
							drive.findElement(CreatAgent.ageClose).click();
						}
	
						else
						{
							wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.ageOk)));
	
							drive.findElement(CreatAgent.ageOk).click();
	
							wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(CreatAgent.ageOk)));
						}
	
					}
					catch (StaleElementReferenceException sere)
					{
	
					}
				}
	
				excel.setCelldata("Agents", r, 8, "Pass", writeresults);
				excel.greencolour("Agents", r, 8, writeresults);
				Thread.sleep(500);
				//		Deleting Agent
				if(delete==true) 
				{
					wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.addAgent)));
					drive.findElement(By.xpath("//table//tr[contains(.,'"+ageName+"')]//child::a[@title='Delete Agent']")).click();	
					wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.ageDelOK)));
					drive.findElement(CreatAgent.ageDelOK).click();
					wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(CreatAgent.ageAcc)));
					drive.findElement(CreatAgent.ageAcc).click();
				}
	
			}



	}

}



