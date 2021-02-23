package element;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class CreatAgent 
{
	public static  String agID = RandomStringUtils.randomNumeric(9);
	public static String agNam = RandomStringUtils.randomAlphabetic(15);
	public static  String agMob = RandomStringUtils.randomNumeric(10);
	public static  String agFX = RandomStringUtils.randomNumeric(10);
	public static  String agZP = RandomStringUtils.randomNumeric(5);


	public static By masterData = By.id("liMaster_Data");
	public static By agent = By.linkText("Agents");

	public static By addAgent = By.id("btnAdd");

	public static By ageID = By.id("AccountID");
	public static By ageName = By.id("AgentName");
	public static By ageConName = By.id("ContactName");
	public static By ageAddress = By.xpath("//input[@id='Address']");
	public static By ageAddress1 = By.xpath("//input[@id='Address1']");
	public static By ageState = By.id("State");
	public static By ageCity = By.id("City");
	public static By ageZIP= By.id("Zip");
	public static By agePhone = By.id("Phone");
	public static By ageEmail = By.id("Email");
	public static By ageFax = By.id("Fax");


	public static By AgeError = By.xpath("//span[@id='spanError']");

	public static By ageSubmit = By.xpath("//button[contains(.,'Submit')]");
	public static By ageClose = By.xpath("//button[contains(.,'Close')]");
	
	public static By ageOk = By.xpath("//button[contains(.,'Ok')]");

	String agenID = agID;
	static String agenName = agNam;
	String agZip = agZP;
	String agMoNo = agMob;
	public static String agEm = ""+agNam+"@amail.club";
	String agFa = agFX;

	public static By ageDEL = By.xpath("//table//tr[contains(.,'"+agenName+"')]//child::a[@title='Delete Agent']");
	public static By ageEDIT = By.xpath("//table//tr[contains(.,'"+agenName+"')]//child::a[@title='Edit Agent']");

	public static By ageDelOK = By.xpath("//button[@id='confirmOk']");
	public static By ageAcc = By.xpath("//button[contains(.,'Ok')]");
	
	public static By error = By.xpath("//span[@id='spanError']");
	
	public static By fromSubBtt = By.xpath("//button[@onclick='Submitform()']");









}
