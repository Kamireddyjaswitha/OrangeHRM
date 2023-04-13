package com.organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Locations {
	  WebDriver driver;
	   @BeforeMethod
	    public void beforeMethod() {
	    
	   try { 
	    driver = new ChromeDriver();
	    FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\searchbar\\searchbardata.properties");
	    Properties p = new Properties();
	    p.load(fis);
	    String url=p.getProperty("url");
		String unvalue = p.getProperty("username");
		String pwvalue = p.getProperty("password");
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(unvalue);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pwvalue);
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		login.click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement admin = driver.findElement(By.xpath("//span[text()='Admin']"));
		admin.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Admin']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement organization = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/span"));
		organization.click();
		WebElement location = driver.findElement(By.linkText("Locations"));
		location.click();
		
		
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	}
	@AfterMethod
	public void afterMethob() {
		driver.quit();
	}
	@Test
	public void searchLocation() {
		try{
			WebElement name =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		name.sendKeys("india");
		WebElement city =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
		city.sendKeys("india");
		WebElement submit =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
		submit.click();
		Thread.sleep(5000);
	}catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
		}
	
	@Test
	public void deleteLocation() {
		try {
			 WebElement delete =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[7]/div/button[1]/i"));
			    delete.click();
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div")).isDisplayed();
				WebElement cancel = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]"));
				cancel.click();
				
				
				Thread.sleep(5000);
			
		}catch(Exception e) {
			   System.out.println(e.getMessage());
		   }
	}
}
