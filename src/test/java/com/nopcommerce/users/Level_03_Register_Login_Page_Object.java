package com.nopcommerce.users;
import commons.AbstractPage;
import pageObjects.nopcommerce.UserCustomerInforPO;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserRegisterPO;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Level_03_Register_Login_Page_Object {
	String source_folder = System.getProperty("user.dir");
	WebDriver driver;
	Select select ;
	String firstName, lastName, email, companyName, passWord;
	AbstractPage abstractPage;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", source_folder + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
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
		
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();
		registerPage = new  UserRegisterPO(driver);
		registerPage.clickToGenderMaleRadionButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.selectDayDropDown("24");
		registerPage.selectMonthDropDown("October");
		registerPage.selectYearDropDown("2020");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyNameTextbox(companyName);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmTextbox(passWord);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccesMessge(), "Your registration completed");
		registerPage.clickToLogoutLink();
		homePage = new UserHomePO(driver);
}
	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPassWordTextbox(passWord);
		loginPage.clickToLoginButton();
		homePage = new UserHomePO(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}
	@Test
	public void TC_03_My_Account() {
		homePage.clickToMyAccountLink();
		customerInforPage = new UserCustomerInforPO(driver);
		Assert.assertTrue(customerInforPage.isGenderFeMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(customerInforPage.getSelectTextDayDropdown(),"24");
		Assert.assertEquals(customerInforPage.getSelectTextMonthDropdown(),"October");
		Assert.assertEquals(customerInforPage.getSelectTextYearDropdown(),"2020");
		Assert.assertEquals(customerInforPage.getCompanyNameTextboxValue(),companyName);
		Assert.assertTrue(customerInforPage.isNewsLetterCheckBoxSelected());
		
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
