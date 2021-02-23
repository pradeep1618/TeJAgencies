package test;

import org.testng.annotations.Test;

import process.AddAgent;
import process.Login;
import utils.Browser;

public class Agent extends Browser
{
	/** 
	 * @parameters Agent Delete
	 * @throws Throwable
	 */
	@Test	
	public void AgentsAdd() throws Throwable
	{
		test= extent.createTest("Add Agent");
		Login enter = new Login();
		enter.signIn();
		AddAgent age=new AddAgent();
		age.create(false);


	}
	
}
