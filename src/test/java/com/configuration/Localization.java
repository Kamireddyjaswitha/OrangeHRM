package com.configuration;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Localization {
	 WebDriver driver;
	   @BeforeClass
	    public void BeforeClass() {
	    
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
		//WebElement more =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]/span"));
		//more.click();
		WebElement configuration = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/span"));
		configuration.click();
		WebElement localization = driver.findElement(By.linkText("Localization"));
		localization.click();
		
		
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void  language() {
		try {
			WebElement language = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/div[2]/i"));
			language.click();

			
			 }catch(Exception e) {
			   System.out.println(e.getMessage());
		   }
	}

@Test
public void  DateFormate() {
	try {
		WebElement dateformat = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div"));
		dateformat.click();

		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button"));
		save.click();
		Thread.sleep(5000);

	  }catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
}
}
