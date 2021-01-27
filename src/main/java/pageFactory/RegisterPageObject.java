package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "gender-female")
	WebElement genderFenale_Radio;
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
	@FindBy(id = "Password")
	WebElement passWordTextBox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassWordTextBox;
	@FindBy(id = "register-button")
	WebElement registerButton;
	@FindBy(xpath = "//div[@class='result']")
	WebElement registerSucessMessge;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
//	public static final String GENDER_FEMALE_RADIO = "//input[@id='gender-female']";
//	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
//	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
//	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
//	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
//	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
//	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
//	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
//	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
//	public static final String CONFIRMPASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
//	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
//	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
//	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public void clickToGenderMaleRadionButton() {
		waitToElementVisible(driver, genderFenale_Radio);
		clickToElement(driver, genderFenale_Radio);
		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);
		
	}

	public void selectDayDropDown(String day) {
		waitToElementClickable(driver, dayDropDown);
		selectItemInDropdown(driver, dayDropDown, day);
		
	}

	public void selectMonthDropDown(String month) {
		waitToElementClickable(driver, monthDropDown);
		selectItemInDropdown(driver, monthDropDown, month);
		
	}

	public void selectYearDropDown(String year) {
		waitToElementClickable(driver, yearDropDown);
		selectItemInDropdown(driver, yearDropDown, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
		
	}

	public void inputToCompanyNameTextbox(String company) {
		waitToElementVisible(driver, companyTextBox);
		sendkeyToElement(driver, companyTextBox, company);
		
	}

	public void inputToConfirmTextbox(String confirm) {
		waitToElementVisible(driver, confirmPassWordTextBox);
		sendkeyToElement(driver, confirmPassWordTextBox, confirm);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passWordTextBox);
		sendkeyToElement(driver, passWordTextBox, password);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public String getRegisterSuccesMessge() {
		waitToElementVisible(driver, registerSucessMessge);
		return getElementText(driver, registerSucessMessge);
	}

	public void clickToLogoutButton() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

}
