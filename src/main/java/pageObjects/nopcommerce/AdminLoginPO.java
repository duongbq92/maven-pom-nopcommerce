package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.AdminLoginPageUI;

public class AdminLoginPO extends AbstractPage{
	WebDriver driver;
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void inputEmailTextBox(String email) {
		waitToElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
		
	}
	public void inputPasswordTexbox(String password) {
		waitToElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public AdminDashboardPO clickToLoginButton() {
		waitToElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	public AdminDashboardPO loginDashbroad(String email, String password) {
		inputEmailTextBox(email);
		inputPasswordTexbox(password);
		return clickToLoginButton();
	}

}
	
