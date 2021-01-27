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

public class Level_08_Register_Login_Rest_Parameter extends AbstractTest{
	
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
	}
	@Test
	public void TC_03_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isGenderFeMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(customerInforPage.getSelectTextDayDropdown(),"24");
		Assert.assertEquals(customerInforPage.getSelectTextMonthDropdown(),"October");
		Assert.assertEquals(customerInforPage.getSelectTextYearDropdown(),"2020");
		Assert.assertEquals(customerInforPage.getCompanyNameTextboxValue(),companyName);
		Assert.assertTrue(customerInforPage.isNewsLetterCheckBoxSelected());
		
	}	//  //l
	@Test
	public void TC_04_Switch_Page_01ShortPage() {
		homePage = customerInforPage.clickToHomeButton(driver);
		
		searchPage = (UserSearchPO) homePage.openLinkByPageName(driver,"Search");
		shippingPage = (UserShippingPO) searchPage.openLinkByPageName(driver,"Shipping & returns");
		sitePage = (UserSitePO) shippingPage.openLinkByPageName(driver,"Sitemap");
		footerPage = (UserFooterMyAccountPO) sitePage.openLinkByPageName(driver,"My account");
		homePage = footerPage.clickToHomeButton(driver);
		wishlistPage = (UserWishlistPO) homePage.openLinkByPageName(driver,"Wishlist");
		
	}
	@Test
	public void TC_04_Switch_Page_02LongPage() {
		wishlistPage.openLinkWithPageName(driver, "Search");;
		searchPage = PageGeneratorManager.getUserSearchPage(driver);
		searchPage.openLinkWithPageName(driver, "Shipping & returns");
		shippingPage = PageGeneratorManager.getUserShippingPage(driver);
		shippingPage.openLinkWithPageName(driver, "Sitemap");
		sitePage = PageGeneratorManager.getUserStiePage(driver);
		sitePage.openLinkWithPageName(driver, "My account");
		footerPage = PageGeneratorManager.getUserFooterPage(driver);
		footerPage.openLinkWithPageName(driver, "Wishlist");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
