package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
public static WebDriver openChromeBrowser()
{
	System.setProperty("webdriver.chrome.driver","F:\\Automation Class\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    return driver;
}

 public static WebDriver openFirefoxDriverBrowser()
 { 
	 System.setProperty("webdriver.gecko.driver","F:\\Automation Class\\geckodriver-v0.30.0-win64\\geckodriver.exe");
 WebDriver driver=new FirefoxDriver(); 
 return driver; 
 }

}
