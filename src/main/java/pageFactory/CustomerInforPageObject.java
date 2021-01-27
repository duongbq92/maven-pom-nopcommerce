package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInforPageObject  extends AbstractPage{
	WebDriver driver;
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-female")
	WebElement genderFenaleRadio;
	@FindBy(id = "FirstName")
	WebElement firstNameTextBox;
	@FindBy(id = "LastName")
	WebElement lastNameTextBox;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropDown;
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropDown;
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropDown;
	@FindBy(id = "Email")
	WebElement emailTextBox;
	@FindBy(id = "Company")
	WebElement companyTextBox;
	@FindBy(id = "Newsletter")
	WebElement newsLetterChecktBox;
	public boolean isGenderMaleRadioButtonSelected() {
		
		return false;
	}
	public boolean isGenderFeMaleRadioButtonSelected() {
		waitToElementVisible(driver, genderFenaleRadio);
		
		return isElementSelected(driver, genderFenaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, firstNameTextBox);
		return getElementAttibute(driver, firstNameTextBox, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, lastNameTextBox);
		return getElementAttibute(driver, lastNameTextBox, "value");
	}

	public String getSelectTextDayDropdown() {
		waitToElementVisible(driver, dayDropDown);
		return getFirstSelectTextInDropdown(driver, dayDropDown);
	}

	public String getSelectTextMonthDropdown() {
		waitToElementVisible(driver, monthDropDown);
		return getFirstSelectTextInDropdown(driver, monthDropDown);
	}

	public String getSelectTextYearDropdown() {
		waitToElementVisible(driver, yearDropDown);
		return getFirstSelectTextInDropdown(driver, yearDropDown);
	}

	public String getCompanyNameTextboxValue() {
		waitToElementClickable(driver, companyTextBox);
		return getElementAttibute(driver, companyTextBox, "value");
	}

	public boolean isNewsLetterCheckBoxSelected() {
		waitToElementClickable(driver, newsLetterChecktBox);
		return isElementSelected(driver, newsLetterChecktBox);
	}

}
