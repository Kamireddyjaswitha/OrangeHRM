package com.usermanagement;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditUsername {
@Test
public void editName() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\usermanagement\\checkboxData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String unvalue = p.getProperty("username");
		String pwvalue = p.getProperty("password");
        //String name = p.getProperty("editedname");
		
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
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[6]/div/button[2]/i"));
		edit.click();
		WebElement uname =driver.findElement(By.cssSelector("input[autocomplete='off'"));
		uname.sendKeys("Admin11111111112223456");		
		WebElement submit =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
		submit.click();
		Thread.sleep(10000);
		driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}


}



