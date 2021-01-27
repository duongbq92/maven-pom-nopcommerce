package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.NopcommerceAbstractPageUI;
import pageUIs.nopcommerce.UserHomePageUI;

public class UserHomePO extends AbstractPage{
	//bien toan cuc - global
	WebDriver driver;
	// ham constructor-khoi tao
	// khi new class nay len homepageobject thi no se chay dau tien
	// khong co kieu tra ve
	// cung ten voi class
	// map = gan gia tri cho driver
	public UserHomePO(WebDriver driver) { // local
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		// button , link , radio, checkbox
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRigisterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		//erro messgse, 
		waitToElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInforPO clickToMyAccountLink() {
		waitToElementClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfor(driver);
	}

	public boolean isRegisterLinkDisplayed() {
		//waitToElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		//waitToElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public boolean isRegisterLinkUnDisplayed() {
		waitToElementInVisible(driver, UserHomePageUI.REGISTER_LINK);
		return  isElementUnDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkUnDisplayed() {
		waitToElementInVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUnDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public void hoverMouseComputerAtMenuBar() {
		waitToElementVisible(driver, UserHomePageUI.COMPUTER_AT_MENU);
		hoverMouseToElement(driver, UserHomePageUI.COMPUTER_AT_MENU);
	}

	public UserDesktopPO clickToDesktopPage() {
		waitToElementClickable(driver, UserHomePageUI.DESKTOP_IN_COMPUTER_AT_MENU);
		clickToElement(driver, UserHomePageUI.DESKTOP_IN_COMPUTER_AT_MENU);
		return PageGeneratorManager.getUserDesktopPage(driver);
	}

	
}
