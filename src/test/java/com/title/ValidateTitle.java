package com.title;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidateTitle {
@Test
	public void getTitle() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\project-1\\src\\test\\java\\com\\title\\titledata.properties");
		Properties p =new Properties();
		p.load(fis);
		String url = p.getProperty("url");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	Thread.sleep(3000);
	String title = driver.getTitle();
	System.out.println("Title is:"+title);
	driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}

