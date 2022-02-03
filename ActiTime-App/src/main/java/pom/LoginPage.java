package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class LoginPage 
{
@FindBy (xpath="//input[@id='username']")
private WebElement UserName;

@FindBy (xpath="//input[@name='pwd']")
 private WebElement Password;
@FindBy (xpath="//div[text()='Login ']")
 private WebElement Login;

public LoginPage(WebDriver driver1)
{
	PageFactory.initElements( driver1,this);
}
public void SendUserName() throws EncryptedDocumentException, IOException
{
	String user=Utility.getDataFromExcelsheet(0,1);
	{
		UserName.sendKeys(user);
	}
	
}

public void SendPassword() throws EncryptedDocumentException, IOException
{
	String user=Utility.getDataFromExcelsheet(1,1);
	{
		Password.sendKeys(user);
	}
}
public void ClickLogin()
{
	if(Login.isDisplayed())
	{
		Login.click();
	}
}





}
