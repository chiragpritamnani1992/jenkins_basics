package jenkins_grid.jenkins_grid;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class multiplewindows {
	
	static WebDriver driver;
	
	public static void main (String[] args)
	{
		switchto();
	}

	
	
	public static void switchto()
	{
	WebDriverManager.chromedriver().setup(); 		
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
	
	driver.findElement(By.xpath("//div/a[@href='http://www.google.com']")).click();
	driver.findElement(By.xpath("//div/a[@href='http://www.facebook.com' and @name='link1']")).click();
	driver.findElement(By.xpath("//div/a[@href='http://www.yahoo.com']")).click();
	
	Set<String> allwindows = driver.getWindowHandles();
	System.out.println("Size of the windows" + " "+ allwindows.size());
	
	
		ArrayList<String> wind= new ArrayList<String>(allwindows);
		
		
		for(int i=wind.size()-1;i>=0;i--)
		{
			driver.switchTo().window(wind.get(i));
			System.out.println("Title of the"+ " "+i+"Window"+ " " + driver.getTitle());
			driver.close();
		}
	

	
	
	}
	
	
	

}
