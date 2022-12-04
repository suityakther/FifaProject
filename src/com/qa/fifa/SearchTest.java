package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	
	
	
	@Test
	public void validateSearch() {
			
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	// type in search box 
	driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
	// trigger the search 
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	// capture the webelement 
	WebElement firstLinks = driver.findElement(By.xpath("(//div[@class= 'ofy7ae'])[1]"));
	String actualText = firstLinks.getText();
	String expected = "FIFA World Cup Qatar 2022™";
	// adding assertion to the test
	Assert.assertTrue(actualText.equalsIgnoreCase(expected), 
			"Expected" + expected + " but found >> " + actualText);
	
		
	}	
	

}
