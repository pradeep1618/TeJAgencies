package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Browser 
{
	public static WebDriver drive;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void reports(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Tej_Agency_Test_Result.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "Test Server");
		extent.setSystemInfo("Tester", "Pradeep K Reddy Chanda");
		htmlReporter.config().setDocumentTitle("TEJ Agencies Test Results");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@AfterMethod
	public void result(ITestResult results)
	{
		if(results.getStatus() == ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(results.getName()+ " Test Case Is Failed", ExtentColor.RED));	
			test.fail(results.getThrowable());
			test.log(Status.INFO, "Test Case Failed");
			test.info(MarkupHelper.createLabel("***FAIL***", ExtentColor.RED));
		}
		else if (results.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(results.getName()+" Test Case Is Pass ", ExtentColor.GREEN));
			test.log(Status.INFO, "Test Case Passed");
			test.info(MarkupHelper.createLabel("***PASS***", ExtentColor.GREEN));
			
		}
		else if(results.getStatus()==ITestResult.SKIP)
		{
			test.skip(MarkupHelper.createLabel(results.getName()+ " Test Case Skip ", ExtentColor.ORANGE));
			test.skip(results.getThrowable());
			test.log(Status.INFO, "Test Case Skip");
			test.info(MarkupHelper.createLabel("***SKIP***", ExtentColor.BLUE));
		}
	}
	
	 @BeforeClass
	  public void beforeClass() 
	  {
		drive=new ChromeDriver();
		drive.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		drive.manage().window().maximize();
		drive.get("https://tejtrack.synergycom.in:8181/");
		
		  
	  }
	 
	 @AfterClass
	 public void afterClass() {
		 extent.flush();
		 drive.close();
		 drive.quit();
	 }
	
}
