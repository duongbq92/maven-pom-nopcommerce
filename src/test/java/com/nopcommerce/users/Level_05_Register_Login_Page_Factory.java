package com.nopcommerce.users;

import commons.AbstractTest;
import pageFactory.CustomerInforPageObject;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory .RegisterPageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_05_Register_Login_Page_Factory extends AbstractTest{
	
	WebDriver driver;
	Select select ;
	String firstName, lastName, email, companyName, passWord;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInforPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		
		firstName = "Quy";
		lastName = "Duong";
		email = "quyduong" +getRamdomNumber()+ "@gmail.com";
		companyName = "Sach";
		passWord = "khongpass";
		
	}
	@Test
	public void TC_01_Register() {
		
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new  RegisterPageObject(driver);
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
		registerPage.clickToLogoutButton();
		homePage = new HomePageObject(driver);
}
	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPassWordTextbox(passWord);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}
	@Test
	public void TC_03_My_Account() {
		homePage.clickToMyAccountLink();
		customerInforPage = new CustomerInforPageObject(driver);
		Assert.assertTrue(customerInforPage.isGenderFeMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(customerInforPage.getSelectTextDayDropdown(),"24");
		Assert.assertEquals(customerInforPage.getSelectTextMonthDropdown(),"October");
		Assert.assertEquals(customerInforPage.getSelectTextYearDropdown(),"2020");
		Assert.assertEquals(customerInforPage.getCompanyNameTextboxValue(),companyName);
		Assert.assertTrue(customerInforPage.isNewsLetterCheckBoxSelected());
		
	}	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
