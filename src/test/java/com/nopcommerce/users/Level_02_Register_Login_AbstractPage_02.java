package com.nopcommerce.users;
import commons.AbstractPage;
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

public class Level_02_Register_Login_AbstractPage_02 extends AbstractPage {
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
		clickToElement(driver,"//a[@class='ico-register']");
		clickToElement(driver,"//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "24");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "2020");
		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyName);
		sendkeyToElement(driver, "//input[@id='Password']", passWord);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", passWord);
		clickToElement(driver, "//input[@id='register-button']");
		
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
		
	}
	@Test
	public void TC_02_Login() {
		clickToElement(driver,"//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", passWord);
		clickToElement(driver, "//input[@value='Log in']");
		
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-logout']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
	}
	@Test
	public void TC_03_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementDisplayed(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getElementAttibute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(getElementAttibute(driver, "//input[@id='LastName']", "value"),lastName);
		Assert.assertEquals(getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "24");
		Assert.assertEquals(getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "October");
		Assert.assertEquals(getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "2020");
		Assert.assertEquals(getElementAttibute(driver, "//input[@id='Company']","value"), companyName);
		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));
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
