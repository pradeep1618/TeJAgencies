package test;

import org.testng.annotations.Test;

import process.AServiceAgents;
import process.Login;
import utils.Browser;

public class ServiceAgentAdd extends Browser
{
	@Test
	public void AddServiceAgent() throws Throwable
	{
		test=extent.createTest("Adding Service Agent");
		Login enter = new Login();
		enter.signIn();
		AServiceAgents serv= new AServiceAgents();
		serv.create(false, true, false);
	}
	
}
