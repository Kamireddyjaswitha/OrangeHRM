package com.searchbar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;


public class Searchbar{
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
   }catch(Exception e) {
	   System.out.println(e.getMessage());
   }
}
@AfterMethod
public void afterMethob() {
	driver.quit();
}

@Test
public void validInputs() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\searchbar\\searchbardata.properties");
		Properties p = new Properties();
		p.load(fis);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String svalue = p.getProperty("searchbar_value1");
		WebElement search = driver.findElement(By.cssSelector("input[placeholder='Search']"));
		search.sendKeys(svalue);
		Thread.sleep(3000);

	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
@Test
public void invalidInputs() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\searchbar\\searchbardata.properties");
		Properties p = new Properties();
		p.load(fis);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String svalue = p.getProperty("searchbar_value2");
		WebElement search = driver.findElement(By.cssSelector("input[placeholder='Search']"));
		search.sendKeys(svalue);
		Thread.sleep(3000);

	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
}

