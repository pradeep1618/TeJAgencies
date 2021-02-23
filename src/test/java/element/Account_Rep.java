package element;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class Account_Rep 
{
	static String screen = "Account Producer";

	
	public static String repNam = RandomStringUtils.randomAlphabetic(15);
	public static  String repMob = RandomStringUtils.randomNumeric(10);
	public static  String repPho = RandomStringUtils.randomNumeric(10);
	public static  String repZP = RandomStringUtils.randomNumeric(5);


	public static By masterData = By.id("liMasterData");
	public static By link = By.linkText(screen);

	public static By repAddBF = By.id("btnAdd");
	public static By repNameF = By.xpath("//input[@id='Name']");
	public static By repPhoneF = By.xpath("//input[@id='Phone']");
	public static By repEmailF = By.xpath("//input[@id='Email']");

	public static By repAddressF = By.xpath("//textarea[@id='MailingAddress']");
	public static By repMobileF = By.xpath("//input[@id='Mobile']");
	public static By repStatF =By.xpath("//select[@id='MailingAddressState']");
	public static By repCityF =By.xpath("//input[@id='MailingAddressCity']");
	public static By repZIPF =By.xpath("//input[@id='MailingAddressZip']");

	public static By repSubmit = By.xpath("//button[contains(.,'Submit')]");
	public static By repClose = By.xpath("//button[contains(.,'Close')]");
	public static By repError = By.xpath("//span[@id='spanError']");

	
	static String repName = repNam;
	String repZip = repZP;
	String repphone = repPho;
	String repMobil = repMob;
	public static String repEmail = ""+repNam+"@yopmail.club";
	
	public static By repDelB = By.xpath("//table//tr[contains(.,'"+repName+"')]//child::a[@title='Delete Account Producer']");
	public static By repEdi = By.xpath("//table//tr[contains(.,'"+repName+"')]//child::a[@title='Edit Agent");
	
	public static By repDelOK = By.xpath("//button[@id='confirmOk']");
	public static By repAcc = By.xpath("//button[contains(.,'Ok')]");


}
