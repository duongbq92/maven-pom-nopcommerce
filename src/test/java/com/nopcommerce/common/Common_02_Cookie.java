package com.nopcommerce.common;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
@Feature("User")
public class Common_02_Cookie extends AbstractTest{
	
	WebDriver driver;
	Select select ;
	String firstName, lastName, companyName;
	public static String email, passWord;
	public static Set<Cookie> allCookies;
	
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
	@BeforeTest
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		firstName = "Quy";
		lastName = "Duong";
		email = "quyduong" +getRamdomNumber()+ "@gmail.com";
		companyName = "Sach";
		passWord = "khongpass";
		
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.geUsertHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Click Gender Male radio button");
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

//		log.info("Register - Step 11: Click to logout link an navigate to Home Page");
//		registerPage.clickToLogoutButton();
		
		allCookies = driver.manage().getCookies();
//		driver.quit();
//		log.info("Login - Step 01:Click to login page");
//		loginPage = homePage.clickToLoginLink();
//		
//		log.info("Login - Step 02: Input email with value"+ email);
//		loginPage.inputToEmailTextbox(email);
//		
//		log.info("Login - Step 03:Input password with value "+ passWord);
//		loginPage.inputToPassWordTextbox(passWord);
//		
//		log.info("Login - Step 04: Click to login button ");
//		homePage = loginPage.clickToLoginButton();
	}
	
}
