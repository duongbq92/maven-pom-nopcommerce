package com.nopcommerce.admin;
import commons.AbstractTest;
import pageObjects.nopcommerce.AdminDashboardPO;
import pageObjects.nopcommerce.AdminLoginPO;
import pageObjects.nopcommerce.AdminProductsPO;
import pageObjects.nopcommerce.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Level_09_Web_Data_Table_And_Upload extends AbstractTest{
	AdminLoginPO loginPage;
	AdminDashboardPO dasboardPage;
	AdminProductsPO productsPage;
	WebDriver driver;
	String email, password;
	String fileName = "Hana1.jpg";
	String pictureAlt = "Bui Nhat Ha";
	String pictureTitle = "Hana";
	String pictureOrder = "1";
	String pictureName = "Apple MacBook Pro 13-inch";
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browsername, String url) {
		driver = getBrowserDriver(browsername, url);
		email = "admin@yourstore.com";
		password = "admin";
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		dasboardPage = loginPage.loginDashbroad(email,password);
		productsPage = dasboardPage.openProductPage();
	}
	@Test
	public void TC_01_Data_Table() {
		// paging
		productsPage.goToPageAtByIndex("2");
//		productsPage.sleepInSecond(3);
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("2"));
		
		productsPage.goToPageAtByIndex("3");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("3"));
		
		productsPage.goToPageAtByIndex("1");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("1"));
}
	//@Test
	public void TC_02_Select_Deselect_All() {
		// Select all
		productsPage.checkToSelectAllCheckbox();
		productsPage.allProductCheckboxChecked();
		
		// Deselect all
		productsPage.uncheckToSelectAllCheckbox();
		productsPage.allunProductCheckboxChecked();
		
		// Check Special
		productsPage.checkProductCheckboxByName("$100 Physical Gift Card");
		productsPage.checkProductCheckboxByName("Apple MacBook Pro 13-inch");
	}
	//@Test
	public void TC_03_Display() {
		Assert.assertTrue(productsPage.areProductDetailDisplayed("Custom T-Shirt","CS_TSHIRT","15","10000","Simple","true"));
//		Assert.assertTrue(productsPage.areProductDetailDisplayed("First Prize Pies","FIRST_PRP","51","10000","Simple","true"));
		
		productsPage.slectShowItemDropdown("50");
		

	}	
//	@Test
	public void TC_04_Position() {
		Assert.assertTrue(productsPage.isInformationDisplayCollumNameAtRowNumber("Product name","1","$100 Physical Gift Card"));
		Assert.assertTrue(productsPage.isInformationDisplayCollumNameAtRowNumber("Stock quantity","3",""));
		Assert.assertTrue(productsPage.isPuslishStatusCollumNameAtRowNumber("Published","1","true"));
	}
	@Test
	public void TC_05_EditAndUploadFile() {
		productsPage.clickToEditByName("Apple iCam");
		productsPage.backToPage(driver);
		
		// search Adobe
		productsPage.inputToProductNameTextBox(pictureName);
		productsPage.clickToSearchButton();
		// goto edit
		productsPage.clickToEditByName(pictureName);
		//scroll upload function 
		productsPage.scrollToPicturePanel();
		productsPage.sleepInSecond(5);
		// click to plus icon
		productsPage.clickToPlusIconByPanelID(driver,"product-pictures");
		// upload file (file name/ title/ atl/ order)
		productsPage.uploadMultipleFiles(driver,fileName);//qq-upload-file-selector qq-upload-file
														  //qq-upload-spinner-selector qq-upload-spinner
		// verify upload 
		Assert.assertTrue(productsPage.isNewPictureUploadSuceess(fileName));
		productsPage.inputAltTextbox(pictureAlt);
		productsPage.inputTitleTextbox(pictureTitle);
		productsPage.inputOrderTextbox("Increase");
		// add to product
		productsPage.clickToAddProductPictureButton();
		// verify on Picture table
		Assert.assertTrue(productsPage.areImageDetailDisplayed(pictureName.toLowerCase().replace(" ", "-"),pictureOrder, pictureAlt,pictureTitle));
		//save  -> goto Adobe
		productsPage.clickToSave();
		
		// search Adobe
		productsPage.inputToProductNameTextBox(pictureName);
		productsPage.clickToSearchButton();
		Assert.assertTrue(productsPage.areIProductlDisplayed(pictureName, pictureName,"AP_MBP_13","1800","10000","Simple","true"));

		// goto edit
		productsPage.clickToEditByName(pictureName);
		//scroll upload function 
		productsPage.scrollToPicturePanel();
		// delete image
		productsPage.clickToDeleteButtonByPictureTitle(pictureTitle);
		//delete all picture
//		productsPage.clickToDeleteAllPicture();
		//save  -> goto Adobe
		productsPage.clickToSave();
		// search Adobe
		productsPage.inputToProductNameTextBox(pictureName);
		productsPage.clickToSearchButton();
		// verify found
		Assert.assertTrue(productsPage.areIProductlDisplayed( pictureName, pictureName,"AP_MBP_13","1800","10000","Simple","true"));

	}
	@Test
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	
}
