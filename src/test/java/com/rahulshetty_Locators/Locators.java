package com.rahulshetty_Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		//FireFox Driver
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Suraj Jungare\\Documents\\geckodriver-v0.34.0-win64\\geckodriver.exe"); 
		//WebDriver driver = new FirefoxDriver(); //how to hit any url on the browser
		
		//Microsoft Edge Driver
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Suraj Jungare\\Documents\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		String name = "Suraj";
		WebDriver driver = new ChromeDriver();
		//Implicit wait  : time in second globaly applicable
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		//Username & Password : rahulshettyacademy
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//SelectorHub : "div[class=\"login-container\"] h2" ==  for Hello,Suraj
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		//Log Out Button : "//button[text()='Log Out']"
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	}
	
	//Dynamically set password
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String [] passwordArray = passwordText.split("'");
		//String [] passwordArray2 = passwordArray[1].split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
		
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to Login.
		
		//0th index - rahulshettyacademy
		//1st index - to Login.
	}
}
