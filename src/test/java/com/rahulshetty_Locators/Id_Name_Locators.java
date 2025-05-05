package com.rahulshetty_Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Id_Name_Locators {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		//Implicit wait  : time in second globaly applicable
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		//Username & Password : rahulshettyacademy
		driver.findElement(By.id("inputUsername")).sendKeys("surajJungare@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		//Error Message : tagName(attribute=”value”) OR tagName.value = p.error
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//Link Text : Find Text on Link :  Forgot your password? 
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		//XPATH : //tagName(@attributeName='value')
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john12@gmail.co.in");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		//CssSelector from SelectorHub when multiple text with different Value (Name, Email, Mobile )
	    driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(3)")).sendKeys("john_321@gmail.com");
		//driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8976504438");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8976504438");
		//Button : Reset 
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("suraj");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
	}
}
