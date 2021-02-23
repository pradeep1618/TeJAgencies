package element;

import org.openqa.selenium.By;

public class AddAcc 
{

public static By accLink = 	By.xpath("//div[@id='liAccounts']");
public static By addAc = By.xpath("//ul[@id='ulAccounts']//a[contains(.,'Add Account')]");
public static By setUpC=By.xpath("//label[contains(.,'Setup Complete')]");
public static By setupComp=By.id("SetupComplete");
public static By accID = By.id("txtAccountID");
public static By accTyp=By.xpath("//select[@id='AccountType']");
public static By accName=By.id("txtAccountName");
public static By Accproducer=By.xpath("//div//following::button[@data-id='ddlAccountProducer']");
public static By AccProName=By.xpath("//*[@id='SubmitForm']/div/div[3]/div[1]/div/div/div/div[1]/div/div[4]/div/div[2]/div/div[1]/input");
public static By SerAgen=By.xpath("//div//following::button[@data-id='ddlServicingAgent']");
public static By SerAgents=By.xpath("//*[@id='SubmitForm']/div/div[3]/div[1]/div/div/div/div[1]/div/div[5]/div/div[2]/div/div[1]/input");
public static By programType=By.xpath("//div[@class='custom-control custom-checkbox']//label[@for='CPP']");
public static By mailNum = By.id("MailingAddress");
public static By mailStreet=By.id("MailingAddress1");
public static By mailCity = By.id("MailingCity");
public static By mailState = By.xpath("//button[@data-id='ddlState']");
public static By mailStateTex = By.xpath("//*[@id=\"divNewAccount\"]/div/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/input");
public static By mailZip=By.xpath("//input[@id='MailingZip']");
public static By copyMail=By.xpath("//label[@for='CopyMailAddress']");
public static By accStatus=By.xpath("//select[@id='Status']");
public static By compSet=By.xpath("//label[@for='SetupComplete']");
public static By activeDate=By.xpath("//input[@id='EODate']");
public static By subButt = By.xpath("//button[@id='btnSubmit']");
public static By cloButt = By.xpath("//button[@id='btnClose']");

public static By popUpSuccess=By.xpath("//button[@class='btn bc-dblue txt-white modalclosesuccess']");


//Elements for account info  

public static By accountinfo = By.xpath("//ul[@id='ulAccounts']//a[contains(.,'Account Search')]");
//public static By infoIcon=By.xpath("//*[@id='tblSearchData']//tr[contains(.,'5002')]//span");
public static By collateralTab=By.xpath("//a[@id='Collateral-tab']");
// Add Collateral

public static By addColl=By.id("headingA");
public static By collCode=By.id("CollateralCode");
public static By collDescription=By.id("Description");

// Delete Account
public static By delIcon=By.xpath("//*[@id='tblSearchData']/tbody/tr[contains(.,'1618')]/td[3]/a/i");
public static By popOk=By.xpath("//button[@id='confirmOk']");
public static By popUpOk=By.xpath("//button[@class='btn bc-dblue txt-white modalclosesuccess']");

	
}
