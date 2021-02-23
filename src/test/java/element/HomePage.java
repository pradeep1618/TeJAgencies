package element;

import org.openqa.selenium.By;

public class HomePage 
{
public static By userName = By.xpath("//input[@id='UserID']");
public static By passWord = By.xpath("//input[@id='passWord']");
public static By logButton = By.id("btnLoginTej");
public static By firstTime = By.linkText("First time user? Register");
public static By forgot = By.linkText("Forgot Password?");
}
