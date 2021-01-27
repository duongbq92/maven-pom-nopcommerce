package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.UserLoginPageUI;

public class UserLoginPO extends  AbstractPage{
	WebDriver driver;
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPassWordTextbox(String passWord) {
		waitToElementClickable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passWord);
		
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.geUsertHomePage(driver);
		
	}

}
