package jenkins_net_demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class netflix_demo {
	
	
	static WebDriver driver;
	static ArrayList<String> email;
	static ArrayList<String> password;
	static write_excel excel;
	
	netflix_demo()
	{
		email= new ArrayList<String>();
		password = new ArrayList<String>();
		excel= new write_excel();
	}
	
//	@Test(priority=1)
//	public void setup()
//	{
//		WebDriverManager.chromedriver().setup();
//		driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://tricksnation.com/free-netflix-account-1");
//		
//	}
//	
//	@Test(priority=2)
//	public void getEmailIDPassword() throws InterruptedException, IOException
//	{
//
//		for(int i=1;i<11;i++)
//		{
//			
//			WebElement link=  driver.findElement(By.xpath("//tbody//tr//td//a[@href='https://tricksnation.com/free-netflix-account-"+i+"/']"));
//			Thread.sleep(1000);
//			link.click();
//			
//			WebElement tableHeader = driver.findElement(By.xpath("//table/caption"));
//			System.out.println("Email id and Password for: "+ " " + tableHeader.getText());
//			
//			Thread.sleep(1000);
//			
//			WebElement Email= driver.findElement(By.xpath("//tbody/tr/td/strong[text()='Email']/..//..//td[2]"));
//			String Email_ID = Email.getText();
//			System.out.println("Email id " + " " + Email.getText());
//			email.add(Email.getText());
//			
//			Thread.sleep(1000);
//			
//			WebElement Password= driver.findElement(By.xpath("//tbody/tr/td/strong[text()='Password']/..//..//td[2]"));
//			String Password_ID = Password.getText();
//			System.out.println("Password" + " " + Password.getText());
//			password.add(Password.getText());
//			
//			String[] dataToWrite={Email_ID,Password_ID};
//			
//			excel.writeExcel(System.getProperty("user.dir")+"\\src\\test\\java","ExportExcel.xlsx","Login", dataToWrite);
//			
//			Thread.sleep(2000);
//			
//			
//		}
//	
//	}
//	@Test(priority=3)
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
	@Test(priority=4)
	public void netflix_setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netflix.com/in/login");
		
	}

	@Test(priority=5)
	public void netflix_login() throws InterruptedException
	{
		WebElement email = driver.findElement(By.cssSelector("#id_userLoginId"));
		email.sendKeys("Ss@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("#id_password"));
		password.sendKeys("Test@");

		WebElement submit = driver.findElement(By.xpath("//button[@data-uia='login-submit-button']"));
		submit.click();
	
	
		Thread.sleep(2000);

		boolean error_flag_1= driver.findElements(By.cssSelector(".ui-message-contents")).size()>0;
		 
		if(error_flag_1) 
		{
			System.out.println("Sorry !! Error Occured while Sign In !! ");
			Thread.sleep(1000);
			driver.quit();
		}
		else
			System.out.println("Sign In Successful");

	}
}
