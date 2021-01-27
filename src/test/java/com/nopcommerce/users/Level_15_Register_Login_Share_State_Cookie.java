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

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_02_Cookie;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
@Feature("User")
public class Level_15_Register_Login_Share_State_Cookie extends AbstractTest{
	
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
		log.info("Precondition - Step 01: open login page ");
		homePage = PageGeneratorManager.geUsertHomePage(driver);
		
		log.info("Precondition - Step 02:Login cookie page ");
		for (Cookie cookie : Common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		homePage.refreshCurrentPage(driver);
		log.info("Precondition - Step 03:verify display myaccount link");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); 
	}
	@Description("Sort ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Cookie() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
//		if(driver!=null) {
//			driver.quit();
//		}
		closeBrowserAndDriver(driver);
		
	}
	
}
