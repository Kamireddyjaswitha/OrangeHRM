package com.loginpage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Password {
@Test
public void enterPassword() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\loginpage\\passworddata.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String pwvalue = p.getProperty("password_value");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pwvalue);
		Thread.sleep(3000);
		driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}
