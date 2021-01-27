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

public class Level_02_Register_Login_AbstractPage_01 {
	String source_folder = System.getProperty("user.dir");
	WebDriver driver;
	Select select ;
	String firstName, lastName, email, companyName, passWord;
	AbstractPage abstractPage;
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", source_folder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
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
		abstractPage.clickToElement(driver,"//a[@class='ico-register']");
		abstractPage.clickToElement(driver,"//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "24");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "2020");
		
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", passWord);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", passWord);
		abstractPage.clickToElement(driver, "//input[@id='register-button']");
		
		
		Assert.assertEquals(abstractPage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
		
	}
	@Test
	public void TC_02_Login() {
		abstractPage.clickToElement(driver,"//a[@class='ico-login']");
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", passWord);
		abstractPage.clickToElement(driver, "//input[@value='Log in']");
		
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-logout']"));
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
	}
	@Test
	public void TC_03_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(abstractPage.getElementAttibute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(abstractPage.getElementAttibute(driver, "//input[@id='LastName']", "value"),lastName);
		Assert.assertEquals(abstractPage.getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "24");
		Assert.assertEquals(abstractPage.getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "October");
		Assert.assertEquals(abstractPage.getFirstSelectTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "2020");
		Assert.assertEquals(abstractPage.getElementAttibute(driver, "//input[@id='Company']","value"), companyName);
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
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
