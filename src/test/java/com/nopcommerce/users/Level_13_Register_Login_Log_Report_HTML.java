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
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_13_Register_Login_Log_Report_HTML extends AbstractTest{
	
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
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.geUsertHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Click Gender Male radio button");
//		registerPage = new  UserRegisterPO(driver);
		registerPage.clickToGenderMaleRadionButton();
		
		log.info("Register - Step 03:Input to firstname Textbox with value" + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 04:Input to lastname Textbox with value"+ lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 05 select date/mon/year ");
		registerPage.selectDayDropDown("24");
		registerPage.selectMonthDropDown("October");
		registerPage.selectYearDropDown("2020");
		
		log.info("Register - Step 06: input email textbox with value" + email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 07: input company name textbox ");
		registerPage.inputToCompanyNameTextbox(companyName);
		
		log.info("Register - Step 08: input password and confirm passoword with value :" + passWord);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmTextbox(passWord);
		
		log.info("Register - Step 09: Click to register button at page register");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 10: verify success display");
		verifyEquals(registerPage.getRegisterSuccesMessge(), "Your registration completed");

		log.info("Register - Step 11: Click to logout link an navigate to Home Page");
		registerPage.clickToLogoutLink();
		
}
	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01:Click to login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input email with value"+ email);
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03:Input password with value "+ passWord);
		loginPage.inputToPassWordTextbox(passWord);
		
		log.info("Login - Step 04: Click to login button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify accout login link ");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); 
		
		log.info("Login - Step 06: Verify logout link");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 07: Verify register login undisplay link");
		verifyFalse(homePage.isRegisterLinkUnDisplayed());

		log.info("Login - Step 08:Verify Login login undisplay link");
		verifyFalse(homePage.isLoginLinkUnDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
