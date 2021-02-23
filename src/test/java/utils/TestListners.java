package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners extends Browser implements ITestListener
{
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		TakeScreenShot.screenShot(drive, result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		TakeScreenShot.screenShot(drive, result.getName());
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) 
	{
		TakeScreenShot.screenShot(drive, result.getName());

	}

}
