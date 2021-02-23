package test;

import org.testng.annotations.Test;

import process.AddAccount;
import process.Login;
import utils.Browser;
import utils.Excel;

public class Accounts extends Browser

{
	@Test
	public void LogIn() throws Throwable 
	{
		test=extent.createTest("Application Log In As Admin");
		Login enter = new Login();
		enter.signIn();
	}
	@Test	
	public void AccountsSetup() throws Throwable
	{
		test=extent.createTest("Account Setup");
		String path = System.getProperty("user.dir");
		Excel sheet = new Excel(path+"/XLData/Agent_Data.xlsx");
		
		AddAccount add = new AddAccount();
		add.addAccounts(sheet.getcelldata("Accounts", 1, 0),sheet.getcelldata("Accounts", 1, 1),sheet.getcelldata("Accounts", 1, 2),
				sheet.getcelldata("Accounts", 1, 3),sheet.getcelldata("Accounts", 1, 4),sheet.getcelldata("Accounts", 1, 5),
				sheet.getcelldata("Accounts", 1, 6),sheet.getcelldata("Accounts", 1, 7),sheet.getcelldata("Accounts", 1, 8),
				sheet.getcelldata("Accounts", 1, 9),sheet.getcelldata("Accounts", 1, 15), sheet.getcelldata("Accounts", 1, 17),
				sheet.getcelldata("Accounts", 1, 16),sheet.getcelldata("Accounts", 1, 19), sheet.getcelldata("Accounts", 1, 21),
				sheet.getcelldata("Accounts", 1, 20),sheet.getcelldata("Accounts", 1, 22), sheet.getcelldata("Accounts", 1, 23));
				
	}
	@Test
	public void DeleteAccount() throws Throwable 
	{
		test=extent.createTest("Delete Account");
		String path = System.getProperty("user.dir");
		Excel sheet = new Excel(path+"/XLData/Agent_Data.xlsx");
		AddAccount add = new AddAccount();
		add.deleteAccount(sheet.getcelldata("Accounts", 1, 0));
	}
	@Test
	public void AccountInfo() throws Throwable 
	{
		test=extent.createTest("Account Info");
		String path = System.getProperty("user.dir");
//		String readData= path+"/XLData/Agent_Data.xlsx";
		Excel sheet = new Excel(path+"/XLData/Agent_Data.xlsx");
//		int rows = sheet.rowCount("Accounts");
		AddAccount add = new AddAccount();
		add.accountCollateral(sheet.getcelldata("Accounts", 1, 0));
	}

}
