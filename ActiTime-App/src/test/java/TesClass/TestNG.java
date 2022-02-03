package TesClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility;
import base.BaseClass;
//import pom.AddUser;
import pom.HomePage;
import pom.LoginPage;

public class TestNG extends BaseClass
{  
  private WebDriver driver;
  private HomePage homepage;
  private LoginPage loginpage;
  private SoftAssert softAssert;
 // private AddUser adduser;
  static ExtentTest test;
  static ExtentHtmlReporter reporter;
   private int testID;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extend.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("launch browser");
		if (browser.equals("chrome"))
		{
			driver=openChromeBrowser();
		}
		if(browser.equals("firefox"))
		{
		driver=openFirefoxDriverBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	@BeforeClass
	public void initializePomClasses()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		//adduser=new AddUser(driver);

	}
	@BeforeMethod
	public void loginActitime() throws EncryptedDocumentException, IOException
	{
		System.out.println("login Actitime");
		driver.get("http://localhost/login.do");
		loginpage.SendUserName();
		loginpage.SendPassword();
		loginpage.ClickLogin();
		softAssert=new SoftAssert();

	}
	@Test
	public void toverifyusertab()
	{
		testID=100;
		System.out.println("toverifyusertab");
		homepage.clickUser();
		String url=driver.getCurrentUrl();
		
	Assert.assertEquals(url, "http://localhost/administration/userlist.do");
	String tital=driver.getTitle();
	softAssert.assertNotEquals(tital, "User List");
	// adduser.adduser();
	 
	 softAssert.assertAll();
	}
	@Test
	public void toverifyreporttab()
	{
		testID=101;

		System.out.println("toverifyreporttab");
		homepage.clickReport();
		String url=driver.getCurrentUrl();
		//Assert.assertEquals(url, "http://localhost/reports/reports.do");
		boolean result=url.equals("http://localhost/reports/reports.do/");
        //Assert.assertTrue(result);
		Assert.assertFalse(result);
        
	}
	@Test
	public void toverifytasktab()
	{		testID=102;

		System.out.println("toverifytasktab");
		homepage.clickTask();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
	}
	
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
		Utility.saveScreenshot(driver,testID);
		System.out.println("logout from actitime");
	homepage.logout();	
	}
   @AfterClass
   public void clearObjects()
   {
	   loginpage=null;
	   homepage=null;
	 //  adduser=null;
   }
   @AfterTest()
   public void closeBrowser()
   {
	   System.out.println("CloseBrowser");
	   driver.quit();
	   driver=null;
	   System.gc();
   }



}
