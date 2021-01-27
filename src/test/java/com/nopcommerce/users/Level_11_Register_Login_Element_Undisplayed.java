package com.nopcommerce.users;
import commons.AbstractTest;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserCustomerInforPO;
import pageObjects.nopcommerce.UserFooterMyAccountPO;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserRegisterPO;
import pageObjects.nopcommerce.UserSearchPO;
import pageObjects.nopcommerce.UserShippingPO;
import pageObjects.nopcommerce.UserSitePO;
import pageObjects.nopcommerce.UserWishlistPO;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_11_Register_Login_Element_Undisplayed extends AbstractTest{
	
	WebDriver driver;
	Select select ;
	String firstName, lastName, email, companyName, passWord;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserSearchPO searchPage;
	UserShippingPO shippingPage;
	UserSitePO sitePage;
	UserFooterMyAccountPO footerPage;
	UserWishlistPO wishlistPage;
	boolean status;
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
		
		homePage = PageGeneratorManager.geUsertHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
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
		
}
	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPassWordTextbox(passWord);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		// verify register link undisplayed
		status = homePage.isRegisterLinkDisplayed();
		System.out.println("Register link status" + status);
		Assert.assertFalse(status);
		// verify Login link undisplayed
		status = homePage.isLoginLinkDisplayed();
		System.out.println("Longin link status" + status);
		Assert.assertFalse(status);
		
		// verify register link undisplayed
		status = homePage.isRegisterLinkUnDisplayed();
		System.out.println("Register link status" + status);
		Assert.assertTrue(status);
		// verify Login link undisplayed
		status = homePage.isLoginLinkUnDisplayed();
		System.out.println("Longin link status" + status);
		Assert.assertTrue(status);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
