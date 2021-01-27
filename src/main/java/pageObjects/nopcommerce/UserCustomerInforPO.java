package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.NopcommerceAbstractPageUI;
import pageUIs.nopcommerce.UserCustomerInforPageUI;
import pageUIs.nopcommerce.UserLoginPageUI;

public class UserCustomerInforPO  extends AbstractPage{
	WebDriver driver;
	public UserCustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isGenderMaleRadioButtonSelected() {
		
		return false;
	}
	public boolean isGenderFeMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttibute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttibute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectTextDayDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectTextInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectTextMonthDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectTextInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectTextYearDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectTextInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getCompanyNameTextboxValue() {
		waitToElementClickable(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttibute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsLetterCheckBoxSelected() {
		waitToElementClickable(driver, UserCustomerInforPageUI.NEWSLETTER_TEXBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.NEWSLETTER_TEXBOX);
	}


}
