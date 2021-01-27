package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.UserDesktopPageUI;

public class UserDesktopPO  extends  AbstractPage{
	WebDriver driver;
	public UserDesktopPO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean areSortedNameByAscending() {
		waitAllToElementVisible(driver, UserDesktopPageUI.ALL_PRODUCT_TITLE_H2);
		return isDataStringSortedAscending(driver,UserDesktopPageUI.ALL_PRODUCT_TITLE_H2);
	}
	public boolean areSortedNameByDescending() {
		waitAllToElementVisible(driver, UserDesktopPageUI.ALL_PRODUCT_TITLE_H2);
		return isDataStringSortedDesceding(driver, UserDesktopPageUI.ALL_PRODUCT_TITLE_H2);
	}
	public void selItemInSortByDro(String itemValue) {
		waitToElementClickable(driver, UserDesktopPageUI.SORT_BY_SEL);
		selectItemInDropdown(driver, UserDesktopPageUI.SORT_BY_SEL, itemValue);
		
	}
	public boolean areSortedPriceByAscending() {
		waitAllToElementVisible(driver, UserDesktopPageUI.PRICES_SPAN);
		return isDataFloatSortedAscending(driver,UserDesktopPageUI.PRICES_SPAN);
	}
	public boolean areSortedPriceByDescending() {
		waitAllToElementVisible(driver, UserDesktopPageUI.PRICES_SPAN);
		return isDataFloatSortedDesceding(driver,UserDesktopPageUI.PRICES_SPAN);
	}
	
}
