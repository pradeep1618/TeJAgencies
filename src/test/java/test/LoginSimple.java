package test;

import org.testng.annotations.Test;

import process.Login;
import utils.Browser;

public class LoginSimple extends Browser
{
	@Test	
	public void Loginto() throws Throwable
	{
		test=extent.createTest("Login");
		Login enter = new Login();
		enter.signIn();


	}
}
