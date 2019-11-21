package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

	public WebDriver driver;

	public void initDriver() {

		if (driver == null) {
			String exePath = "E:\\chrome\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		}
	}

	@BeforeClass
	public void browserSetup() throws Exception {

		initDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://devqa11-go.vroozi.com/#/login");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://devqa11-go.vroozi.com/#/login");

		System.out.println("Web Page open successfully");

	}

	@Test(priority =1)
	public void Login() throws Exception {
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.name("email"));
		username.clear();
		username.sendKeys("notifyvroozi3+employee@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("input[type=password]"));
		password.clear();
		password.sendKeys("Welcome1");

		WebElement SubmitbButton = driver.findElement(By.cssSelector("button[type=submit]"));

		SubmitbButton.click();
		
		
		Thread.sleep(5000);
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement siteImage = wait.until(ExpectedConditions.elementToBeClickable(By.className("brand-logo")));
		System.out.println("Login Successfully....");
		
		driver.findElement(By.cssSelector(".icon-angle-down:nth-child(2)")).click();
		
		
	    driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
	    Thread.sleep(3000);
	    WebElement profile= driver.findElement(By.id("profile_username"));
	    String profileuser=profile.getText();
	    System.out.println(profileuser);
	    Assert.assertEquals(profileuser, "notifyvroozi3+employee@gmail.com");
	    System.out.println("You are Login In with correct account");
	  

	}
	@Test(priority =2)
	public void DataValidation() throws Exception {
		
		
		
		Thread .sleep(5000);
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Free Text')]")).click();
		
		
	}
	
	
	

	
	
	
}
	


