package element;

import org.openqa.selenium.By;

public class ServiceAgent 
{
public static By master = By.id("liMasterData");
public static By processlnk = By.linkText("Servicing Agent");


public static By AddSerAge = By.xpath("//button[contains(.,' Add Servicing Agent')]");

public static By popUp = By.xpath("//div[@id='AccountManagerAddModal']");
public static By sAname = By.xpath("//input[@id='Name']");
public static By sAMailing = By.xpath("//textarea[@id='MailingAddress']");
public static By sAMailCity = By.xpath("//input[@id='MailingAddressCity']");
public static By sAMailState = By.xpath("//select[@id='MailingAddressState']");
public static By sAMailZip = By.xpath("//input[@id='MailingAddressZip']");
public static By sAStreet = By.xpath("//textarea[@id='StreetAddress']");
public static By sAStreetCity= By.xpath("//input[@id='StreetAddressCity']");
public static By sAStreetState= By.xpath("//select[@id='StreetAddressState']");
public static By sAStreetZip = By.xpath("//input[@id='StreetAddressZip']");
public static By sAEmail = By.xpath("//input[@id='Email']");
public static By sAPhone = By.xpath("//input[@id='Phone']");
public static By sAMobile = By.xpath("//input[@id='Mobile']");
public static By sANote = By.xpath("//textarea[@id='Note']");

public static By sASubmit = By.xpath("//button[@onclick='Submitform()']");
public static By sAClose = By.xpath("//button[contains(.,'Close')]");
public static By sAOkay = By.xpath("//button[@class='btn bc-dblue txt-white modalclosesuccess']");

public static By sADelOK = By.xpath("//button[@id='confirmOk']");
public static By sADelConf = By.xpath("//button[contains(.,'Ok')]");

public static By sAError = By.xpath("//span[@id='spanError']");

public static By sADelIcon = By.xpath("//table//tr[contains(.,'"+sAname+"')]//child::a[@title='Delete Servicing Agent']");
public static By sAEditIcon = By.xpath("//table//tr[contains(.,'"+sAname+"')]//child::a[@id='btnUpdateEmp']");


public static By sAPdf = By.xpath("//button[@class='dt-button buttons-pdf buttons-html5']");
public static By sAExcel = By.xpath("//button[@class='dt-button buttons-excel buttons-html5']");

}
