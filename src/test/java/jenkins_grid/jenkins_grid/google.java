package jenkins_grid.jenkins_grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class google {

	static WebDriver driver = null;
	static boolean grid = false;
		
	@BeforeTest()
	@Parameters({"browser"})
	public void setUp(String browser) throws MalformedURLException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			if(grid)
			{
				driver = new RemoteWebDriver(new URL("http://192.168.1.103:4444/wd/hub"),cap);
			}
			else
			{
				WebDriverManager.chromedriver().setup(); 		
				driver = new ChromeDriver();	
			}
				
			driver.manage().window().maximize(); 
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.DAYS); //Element not found execption
			driver.manage().deleteAllCookies();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{	

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			if(grid)
			{
				driver = new RemoteWebDriver(new URL("http://192.168.1.103:4444/wd/hub"),cap);
			}
			else
			{
				WebDriverManager.firefoxdriver().setup(); 	
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize(); 		
			driver.manage().deleteAllCookies();
		
		}
	}	

	
	
	@Test()
	public static void login_1() throws InterruptedException, MalformedURLException
	{
		System.out.println("Test1 Started....." + Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Guitar");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='sbtc']"));
		Thread.sleep(1000);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String allList = list.get(i).getText();
			if(allList.equalsIgnoreCase("guitar chords"))
			{
				list.get(i).click();
				break;
			}
		}
		System.out.println("Test1 Ended.....");
		
	}
	@Test()
	public static void login_2() throws InterruptedException, MalformedURLException
	{
		System.out.println("Test2 Started....." + Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Guitar");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='sbtc']"));
		Thread.sleep(1000);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String allList = list.get(i).getText();
			if(allList.equalsIgnoreCase("guitar chords"))
			{
				list.get(i).click();
				break;
			}
		}
		System.out.println("Test2 Ended.....");
		
	}
	
	@Test()
	public static void login_3() throws InterruptedException, MalformedURLException
	{
		System.out.println("Test3 Started....." + Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Guitar");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='sbtc']"));
		Thread.sleep(1000);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String allList = list.get(i).getText();
			if(allList.equalsIgnoreCase("guitar chords"))
			{
				list.get(i).click();
				break;
			}
		}
		System.out.println("Test3 Ended.....");
		
	}
	
	@Test()
	public static void login_4() throws InterruptedException, MalformedURLException
	{
		System.out.println("Test4 Started....." + Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Guitar");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='sbtc']"));
		Thread.sleep(1000);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String allList = list.get(i).getText();
			if(allList.equalsIgnoreCase("guitar chords"))
			{
				list.get(i).click();
				break;
			}
		}
		System.out.println("Test4 Ended.....");
		
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}
