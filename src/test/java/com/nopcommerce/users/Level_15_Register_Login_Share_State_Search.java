package com.nopcommerce.users;
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

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
@Feature("User")
public class Level_15_Register_Login_Share_State_Search extends AbstractTest{
	
	WebDriver driver;
	
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
		
		homePage = PageGeneratorManager.geUsertHomePage(driver);
		
		log.info("Login - Step 01:Click to login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input email with value"+ Common_01_Register.email);
		loginPage.inputToEmailTextbox(Common_01_Register.email);
		
		log.info("Login - Step 03:Input password with value "+ Common_01_Register.passWord);
		loginPage.inputToPassWordTextbox(Common_01_Register.passWord);
		
		log.info("Login - Step 04: Click to login button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify accout login link ");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); 
	}
	@Description("Register ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Search() {
		
		
}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
