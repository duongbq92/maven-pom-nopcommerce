package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.AdminProductsPageUI;

public class AdminDashboardPO extends AbstractPage{
	WebDriver driver;
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
	public AdminProductsPO openProductPage() {
		waitToElementClickable(driver, AdminProductsPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminProductsPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitToAjaxLoadingPage(driver);
		waitToElementClickable(driver, AdminProductsPageUI.PRODUCT_LINK_TEXT);
		clickToElement(driver, AdminProductsPageUI.PRODUCT_LINK_TEXT);
		waitToAjaxLoadingPage(driver);
		return PageGeneratorManager.getAdminProductsPage(driver);
	}

}
