package test;

import org.testng.annotations.Test;

import process.AddAccRepresn;
import process.Login;
import utils.Browser;

public class Acc_Representative extends Browser
{

	@Test	
	public void AccRepresntativeAdd() throws Throwable
	{
		test=extent.createTest("Add Account Producer");
		Login enter = new Login();
		enter.signIn();
		AddAccRepresn accCreat = new AddAccRepresn();
		accCreat.accRepresentative(false);



	}
}
