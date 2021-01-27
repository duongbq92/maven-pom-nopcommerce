package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.NopcommerceAbstractPageUI;
import pageUIs.nopcommerce.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage{
	WebDriver driver;
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Gender Male RadioButton")
	public void clickToGenderMaleRadionButton() {
		waitToElementVisible(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
		
	}

	@Step("Input FirstName testbox {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}
	
	@Step("Input LastName testbox {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	@Step("Select Day dropdown")
	public void selectDayDropDown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
		
	}

	@Step("Select moth dropdown")
	public void selectMonthDropDown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
		
	}

	@Step("Select year dropdown")
	public void selectYearDropDown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
		
	}
	
	@Step("Input email testbox {0}")
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	@Step("Input copanyName testbox {0}")
	public void inputToCompanyNameTextbox(String company) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
		
	}

	@Step("Input confirm pass testbox {0}")
	public void inputToConfirmTextbox(String confirm) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirm);
		
	}
	@Step("Input pass testbox {0}")
	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	@Step("Click to register button")
	public void clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}

	@Step("get text register succes")
	public String getRegisterSuccesMessge() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("Click to logout button")
	public void clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		
	}

	

}
