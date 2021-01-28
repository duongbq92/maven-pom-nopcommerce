package com.nopcommerce.users;
import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.UserCustomerInforPO;
import pageObjects.nopcommerce.UserDesktopPO;
import pageObjects.nopcommerce.UserFooterMyAccountPO;
import pageObjects.nopcommerce.UserHomePO;
import pageObjects.nopcommerce.UserLoginPO;
import pageObjects.nopcommerce.UserRegisterPO;
import pageObjects.nopcommerce.UserSearchPO;
import pageObjects.nopcommerce.UserShippingPO;
import pageObjects.nopcommerce.UserSitePO;
import pageObjects.nopcommerce.UserWishlistPO;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
@Feature("User")
public class Level_19_Sort_ASC_DESC extends AbstractTest{
	
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
	UserDesktopPO desktopPage;
	boolean status;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		log.info("Precondition - Step 01: open home page ");
		homePage = PageGeneratorManager.geUsertHomePage(driver);
	}
	@Description("Sort ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Sort_By_Deskop() {
		log.info("Home Page - Step 01: Move and hover to Computer at Menu bar ");
		homePage.hoverMouseComputerAtMenuBar();
		
		log.info("Desktop Page - Step 01: Click page desktop ");
		desktopPage = homePage.clickToDesktopPage();
		
		log.info("Desktop Page - Step 02: Click dropdown Sort By : Name A to Z "); 
		desktopPage.selItemInSortByDro("Name: A to Z");
		
		log.info("Desktop Page - Step 03: Verify Sort By : Name A to Z "); 
		verifyTrue(desktopPage.areSortedNameByAscending());
		
		log.info("Desktop Page - Step 04: Click dropdown Sort By : Name Z to A"); 
		desktopPage.selItemInSortByDro("Name: Z to A");
		
		log.info("Desktop Page - Step 05: Verify Sort By : Name Z to A");
		verifyTrue(desktopPage.areSortedNameByDescending());
		
		log.info("Desktop Page - Step 06: Click dropdown Sort By : Price: Low to High"); 
		desktopPage.selItemInSortByDro("Price: Low to High");
		
		log.info("Desktop Page - Step 07: Verify Sort By : Price: Low to High");
		verifyTrue(desktopPage.areSortedPriceByAscending());
		
		log.info("Desktop Page - Step 08: Click dropdown Sort By : Price: High to Low"); 
		desktopPage.selItemInSortByDro("Price: High to Low");
		
		log.info("Desktop Page - Step 09: Verify Sort By : Price: High to Low");
		verifyTrue(desktopPage.areSortedPriceByDescending());
		
		log.info("Desktop Page - Step End: The End");
//		log.info("Desktop Page - Step 10: Verify Sort By : Price: Low to High");
//		verifyTrue(desktopPage.areSortedDateByAscending());
//		
//		log.info("Desktop Page - Step 11: Click dropdown Sort By : Price: High to Low"); 
//		desktopPage.selItemInSortByDro("Price: High to Low");
//		desktopPage.sleepInSecond(3);
//		
//		log.info("Desktop Page - Step 12: Verify Sort By : Price: High to Low");
//		verifyTrue(desktopPage.areSortedDateByDescending());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
		
	}
	
}
