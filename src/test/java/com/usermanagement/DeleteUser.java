package com.usermanagement;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteUser {
@Test
public void Delete() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\OrangeHRM Project-1\\src\\test\\java\\com\\usermanagement\\deleteData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String unvalue = p.getProperty("username");
		String pwvalue = p.getProperty("password");
        
		
		ChromeDriver driver = new ChromeDriver();
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
	    WebElement delete =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[4]/div/div[6]/div/button[1]/i"));
	    delete.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div")).isDisplayed();
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]"));
		cancel.click();
		
		
		Thread.sleep(5000);

		driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}
