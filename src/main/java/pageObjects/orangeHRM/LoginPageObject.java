package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserName(String userName) {
		waitToElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void enterToPasswordTextbox(String passWord) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
		
	}

	public DashboardPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboard(driver);
	}
	
}
