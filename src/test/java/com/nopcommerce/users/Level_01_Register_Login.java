package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Level_01_Register_Login {
	String source_folder = System.getProperty("user.dir");
	WebDriver driver;
	Select select ;
	String firstName, lastName, email, companyName, passWord;
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", source_folder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		firstName = "Quy";
		lastName = "Duong";
		email = "quyduong" +getRamdomNumber()+ "@gmail.com";
		companyName = "Sach";
		passWord = "khongpass";
		
	}
	@Test
	public void TC_01_Register() {
		driver.findElement(By.cssSelector(".ico-register")).click();
		
		driver.findElement(By.id("gender-male")).click();
		
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText("24");
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText("October");
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText("2020");
		
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(passWord);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector(".ico-logout")).click();
		
	}
	@Test
	public void TC_02_Login() {
		driver.findElement(By.cssSelector(".ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(passWord);
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
	}
	@Test
	public void TC_03_My_Account() {
		driver.findElement(By.cssSelector(".ico-account")).click();
		
		Assert.assertTrue(driver.findElement(By.id("gender-male")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);
		
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"24");
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"October");
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"2020");
		
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"),companyName);
	}
	
	public int getRamdomNumber() {
		Random random = new Random();
		return random.nextInt(99);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
