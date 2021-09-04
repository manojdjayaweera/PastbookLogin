import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcaseLoginEmail{
	
	public static void main (String[] args) throws InterruptedException {
		
		//Webdriver manager initiation
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Pastbook homepage link
		driver.get("https://moments.pastbook.com/");
		
		//Clicks on the SignIn button
		WebElement signbutton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
		signbutton.click();
		
		Thread.sleep(2000);
		
		//Pop-up windows handler
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		//Gets the main window ID 
		String parentWindowId = it.next();
		System.out.println("parent window id:"+ parentWindowId);
		
		//Switches to the pop up window ( login popup)
		String childWindowId = it.next();
		System.out.println("child window id:"+childWindowId);
		driver.switchTo().window(childWindowId);
		driver.manage().window().maximize();
		System.out.println("child window title" +driver.getTitle());
		
		//Clicks on the login with email link 
		WebElement clicklink = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/div[2]/a"));
		clicklink.click();
		//Enter email for Email login
		WebElement email = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/form/div[2]/input[1]"));
		email.click();
		email.sendKeys("clipcogaming@gmail.com");
		email.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//Enter password for Email login
		WebElement pwd = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/form/div[2]/input[2]"));
		pwd.sendKeys("R687!7CsvdfS!Jj");
		pwd.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		//Close pop up window
		driver.close();
		
		//switches back to main window
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title" +driver.getTitle());
		driver.close();
	}

 }

