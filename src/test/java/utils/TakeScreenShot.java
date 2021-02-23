package utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot 
{
	static File source;

	public static void screenShot(WebDriver webDriver, String ScreenShotName) 
	{

		try {
			
			source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, 
					new File("E:\\PradeepKR\\Personal Folder\\Eclipse_Workspase\\agencies\\Scrn_Shot\\"+ScreenShotName+".png"));
			

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}


	/*
	 * File screen=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	 * //copy into local system FileUtils.copyFile(screen, new
	 * File("D:/PradeepKR/Eclipse_Workspase/agencies/Reports/"+ScreenShotName+""));
	 * FileUtils.copyFile(source, 
					new File("E:\\PradeepKR\\Eclipse_Workspase\\agencies\\Scrn_Shot\\"+ScreenShotName+".png"));
	 */
}


