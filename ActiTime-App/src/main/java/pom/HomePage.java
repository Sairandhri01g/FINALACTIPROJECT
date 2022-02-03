package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage 
{
@FindBy (xpath="//a[@class='content users']")
	private WebElement user;
@FindBy (xpath="//a[@class='content reports']")
 private WebElement report;
@FindBy (xpath="//a[@class='content tasks']")
 private WebElement task;
@FindBy(xpath="//a[text()='Logout']")
private WebElement logout;
	
	public HomePage(WebDriver driver1)
	{
		PageFactory.initElements( driver1,this);
	}
	public void clickUser()
	{
		user.click();
	}
	public void clickReport()
	{
		report.click();
	}
	
	public void clickTask()
	{
		task.click();
	}
	public void logout()
	{
		logout.click();
	}
	
}
